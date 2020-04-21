pipeline {
    options {
        buildDiscarder(
                logRotator(
                        numToKeepStr: '30',
                        artifactDaysToKeepStr: '20',
                        artifactNumToKeepStr: '30',
                        daysToKeepStr: '20',
                )
        )
        timestamps()
    }

    agent {
        label 'youcruitbuilder'
    }

    stages {
        stage('Checkout') {
            options {
                timeout(time: 2, unit: 'MINUTES')
            }
            steps {
                checkout scm
            }
        }

        stage('Build, Lint and Test Everything (Java & Script)') {
            options {
                timeout(time: 10, unit: 'MINUTES')
            }

            steps {
                sh "./mvnw clean install"
            }
        }
    }
    post {
        always {
            sh "rm -rf */*/node_modules"
            recordIssues(
                ignoreQualityGate: true,
                enabledForFailure: true,
                qualityGates: [[threshold: 1, type: 'NEW', unstable: true]],
                referenceJobName: 'YouCruit-CI/mailchimp-v3-java-client/master',
                tools: [
                    java(),
                    mavenConsole(),
                    pmdParser(pattern: '**/pmd.xml'),
                    spotBugs(pattern: '**/findbugsXml.xml'),
                    checkStyle(pattern: '**/checkstyle-result.xml'),
                    kotlin(),
                    ktLint(pattern: '**/ktlint*.xml'),
                    jsLint(pattern: '**/jslint.xml')
                ]
            )
            // step([$class: 'CoberturaPublisher', coberturaReportFile: '**/cobertura-coverage.xml'])
            sh 'find . -name "*.xml" -print0 | xargs -0 touch'
            try {
                junit(testResults: '**/build/test-results/**/TEST-*.xml')
            } catch (e) {}
            archiveArtifacts artifacts: '**/build/test-results/**/TEST-*.xml', fingerprint: false, allowEmptyArchive: false
        }

        cleanup {
            sh 'killall mongod || true'
        }
    }
}

