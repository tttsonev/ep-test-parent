package com.ep.api.tests;



import com.ep.api.tests.BaseTest;
import junitparams.JUnitParamsRunner;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;


@RunWith(JUnitParamsRunner.class)
public class ParameterizedTestsRunner extends BaseTest {

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();



}
