package fr.istic.taa.Server;/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import fr.istic.taa.Server.Meteo.JSonHandler;
import fr.istic.taa.Server.Meteo.MeteoHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleDataJpaApplication {

	public void run(String ... args){

    }

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(SampleDataJpaApplication.class, args);
		MeteoHandler met =JSonHandler.getMeteoPinPoint(48,1);
		//met.list.forEach(e -> System.out.println("date" +e.getDt() +"\n clouds "+e.getClouds()));
	}

}
