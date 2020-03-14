package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
   public static void main(String[] args){
       String expected="cba";
       String toReverse="abc";
       String actual=reverseString(toReverse);
       verifyEquals(expected,actual);
   }

   // annotation
   @Test(description = "Verify if method can reverse a string")
   public void test(){
       String expected="elpa";
       String actual=reverseString("apple");
       // it is coming from testng, junit also has this class
       // you can compare any data types here: strings, primitives, arrays, objects
       // to verify if expected result is equals to actual
       Assert.assertEquals(actual,expected);
   }

   @Test(description = "Verify if method can reverse a string")
   public void test2(){
       String expected="rac";
       String actual=reverseString("car");
       Assert.assertEquals(actual,expected);
   }

   public static  boolean verifyEquals(String expected,String actual){
       if(expected.equals(actual)){
           System.out.println("TEST PASSED");
           return true;
       }else{
           System.out.println("TEST FAILED");
           System.out.println("Expected: "+expected);
           System.out.println("Actual: "+actual);
           return false;
       }
   }

    public static String reverseString(String str){
        String reversed="";
        for(int i=str.length()-1;i>=0;i--){
            reversed += str.charAt(i);
        }
        return reversed;
    }
}
