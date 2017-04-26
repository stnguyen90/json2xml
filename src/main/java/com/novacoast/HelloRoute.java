package com.novacoast;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by stnguyen90 on 4/26/17.
 */
public class HelloRoute extends RouteBuilder {

    /*<route id="helloRoute">
          <!-- incoming requests from the servlet is routed -->
          <from uri=""/>
          <choice>
            <when>
              <!-- is there a header with the key name? -->
              <header>name</header>
              <!-- yes so return back a message to the user -->
              <transform>
                 <simple></simple>
              </transform>
            </when>
            <otherwise>
              <!-- if no name parameter then output a syntax to the user -->
              <transform>
                <constant></constant>
              </transform>
            </otherwise>
          </choice>
        </route>*/
    public void configure() throws Exception {
        from("servlet:hello")
                .choice()
                .when(header("name"))
                .transform(simple("Hi I am ${sys.config}. HelloRoute ${header.name} how are you today?"))
                .otherwise()
                .transform(constant("Add a name parameter to uri, eg ?name=foo"))
        ;
    }
}
