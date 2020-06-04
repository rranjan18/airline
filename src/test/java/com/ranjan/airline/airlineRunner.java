package com.ranjan.airline;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AirlineContTest.class, AirlineServiceTest.class, JWTutillTest.class })
public class airlineRunner {

}
