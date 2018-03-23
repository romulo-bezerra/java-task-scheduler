/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.timertaskscheduler.app;

import br.edu.ifpb.timertaskscheduler.service.Agendador;
import java.util.Timer;

/**
 *
 * @author romulo
 */
public class TimerTaskApp {

    public static void main(String[] args) {

        Timer timer = new Timer();
        Agendador agendador = new Agendador();
        timer.schedule(agendador, 0, 1000);

        while (true) {
            System.out.println("Alerta de execução ...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
