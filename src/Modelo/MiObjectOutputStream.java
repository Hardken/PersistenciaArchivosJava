/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author andre
 */
public class MiObjectOutputStream extends ObjectOutputStream
{
public MiObjectOutputStream(OutputStream salida) throws IOException
{
super(salida);
}
protected MiObjectOutputStream() throws IOException, SecurityException
{
super();
}
protected void writeStreamHeader() throws IOException
{
}
}
