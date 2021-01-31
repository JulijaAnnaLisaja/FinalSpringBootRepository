pipelineJob('pipelineJob') {
    definition {
        cps {
            script(readFileFromWorkspace('pipelineJob.groovy'))
            sandbox()
        }
    }
}

pipelineJob('spring boot CSE application') {
    definition {
        cpsScm {
            scm{
                git {
                    remote {
                        url 'https://github.com/JulijaAnnaLisaja/FinalSpringBootRepository.git'
                    }
                    branch 'master'
                }
            }
        }
    }
}