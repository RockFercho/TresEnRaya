/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.controller.communication;

/**
 * Create an instance of communicator.
 * 
 * @author Sergio Uriona
 */
public class FactoryCommunication {
    
    /**
     * Represents the communicator of game.
     */
    private static Communication communication = null;
    
    /**
     * Initialize a communicator.
     * @param n 
     */
    public static void createCommunication(int n) {
        switch (n) {
            case 1: communication = new PlayerCommunication(); break;
            case 2: communication = new ComputerCommunication(); break;
        }
    }
    
    /**
     * Returns an instance of communicator.
     * @return 
     */
    public static Communication getCommunicator() {
        return communication;
    }
    
    /**
     * Destroy the instance of communicator.
     */
    public static void destroyCommunicator() {
        communication = null;
    }
}
