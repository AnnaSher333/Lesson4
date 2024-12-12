package Ex1;

import Ex1.Exception.IncorrectPinException;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IncorrectPinException {
    TerminalImpl terminal = new TerminalImpl();
    terminal.start();
    }
    }

