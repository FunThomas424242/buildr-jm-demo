# Version number for this release
VERSION_NUMBER = "1.0.0-SNAPSHOT"

# Specify Maven 2.0 remote repositories here, like this:
repositories.remote << "http://jcenter.bintray.com"

LOGBACK = ['ch.qos.logback:logback-classic:jar:1.0.7']

# to find transitive dependencies, uncomment the next two lines. The result can then be used to explicitly
# pin the dependencies like shown in the third line. Alternatively, transitive(LOGBACK) adds all transitive
# dependencies directly (as shown in line 32).

#pp transitive(LOGBACK).map {|x| x.to_spec}
#exit
#LOGBACK = ['ch.qos.logback:logback-classic:jar:1.0.7', 'ch.qos.logback:logback-core:jar:1.0.7', 'org.slf4j:slf4j-api:jar:1.6.6']

desc "The Multi-java project"
define "multi-java" do

  project.version = VERSION_NUMBER
  project.group = "com.innoq.buildrdemo"

  define "api" do
    compile.using(:source => '1.5', :target => '1.5')
    compile.with # Add classpath dependencies
    package(:jar)
    package(:javadoc)
    package(:sources)
  end

  define "impl" do
    compile.with transitive(LOGBACK), project("api")
    test.compile.with # Add classpath dependencies
    test.exclude "*Failing*" unless !$stdout.isatty     # example for conditional excludes
    # test.exclude('*') if Buildr.environment == 'notest' # example for conditional excludes
    package(:jar)
    run.using :main => "com.innoq.buildr.Calc"
  end

end
