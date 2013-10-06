/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laadadra.fitools.example;

import com.laadadra.fitools.option.Call;
import com.laadadra.fitools.option.Option;

/**
 *
 * @author nabil.laadadra
 */
public class MainOption
{
  public static void main(String args[])
  {
    Call call = new Call(49, 50, 0.3846, 0.05, 0., 0.2);
    System.err.println(call.price());
  }
}
