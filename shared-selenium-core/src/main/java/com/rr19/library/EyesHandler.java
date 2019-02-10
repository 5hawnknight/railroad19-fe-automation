package com.rr19.library;

import com.applitools.eyes.selenium.Eyes;

public class EyesHandler
{
    private static ThreadLocal<Eyes> eyes = new ThreadLocal<>();

    public static Eyes eyes()
    {
        return eyes.get();
    }

    public static void setEyes(Eyes _eyes)
    {
        eyes.set(_eyes);
    }
}