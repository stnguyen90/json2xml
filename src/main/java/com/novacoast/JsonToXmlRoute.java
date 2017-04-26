package com.novacoast;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by stnguyen90 on 4/26/17.
 */
public class JsonToXmlRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("file:{{in.path}}?move=archive")
            .log("${body}")
            .unmarshal().xmljson()
            .log("${body}")
            .setHeader(Exchange.FILE_NAME, simple("${file:onlyname.noext}.xml"))
            .to("file:{{out.path}}")
        ;
    }
}
