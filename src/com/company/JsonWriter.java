package com.company;

import java.io.IOException;
import java.io.Writer;

public class JsonWriter {
    Writer writer;

    public JsonWriter(Writer writer) {
        this.writer = writer;
    }

    protected void writeObjectBegin() {
        try {
            writer.append('{');
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void writeObjectEnd() {
        try {
            writer.append('}');
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void writeArrayBegin() {
        try {
            writer.append('[');
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void writeArrayEnd() {
        try {
            writer.append(']');
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void writeString(String s) {

    }

    protected void writeNumber(Number num){

    }

    protected void writeSeparator(){

    }

    protected void writePropertySeparator() {

    }

    protected void writeBoolean() {

    }

    protected void writeNull() {

    }

    protected void flush() {

    }
}
