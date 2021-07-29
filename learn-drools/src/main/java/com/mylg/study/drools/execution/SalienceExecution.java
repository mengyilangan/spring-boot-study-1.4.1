/**
 * @author mylg
 * @date 2021-07-20
 */
package com.mylg.study.drools.execution;

import com.mylg.study.drools.data.model.MyFact;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class SalienceExecution {
    public static void main(String[] args) {
        // From the kie services, a container is created from the classpath
        KieServices ks = KieServices.get();
        KieContainer kc = ks.getKieClasspathContainer();
        execute(ks, kc);
    }

    public static void execute(KieServices ks, KieContainer kc) {
        // From the container, a session is created based on
        // its definition and configuration in the META-INF/kmodule.xml file
        KieSession ksession = kc.newKieSession("HelloWorldKS");

        // The application can also setup listeners
        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        // Set up a file based audit logger
        KieRuntimeLogger logger = ks.getLoggers().newFileLogger(ksession, "./Salience");

        // To set up a ThreadedFileLogger, so that the audit view reflects events whilst debugging,
        // uncomment the next line
        // KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( ksession, "./helloworld", 1000 );

        // The application can insert facts into the session
        final MyFact myFact = new MyFact();
        ksession.insert(myFact);
        // and fire the rules
        ksession.fireAllRules();

        // Close logger
        logger.close();

        // and then dispose the session
        ksession.dispose();
    }

}
