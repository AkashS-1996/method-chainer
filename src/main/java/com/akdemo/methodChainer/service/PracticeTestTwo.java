package com.akdemo.methodChainer.service;

import java.util.Observable;
import java.util.Observer;

public class PracticeTestTwo {
    static class Watcher implements Observer{
		@Override
		public void update(Observable o, Object arg) {
			System.out.println(arg.toString());
		}
    }
    
    static class BeingWatched extends Observable{
		void counter(int period) {
			for (; period >= 0; period--) {
				setChanged();
				notifyObservers(new Integer(period));
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("Sleep interrupted");
				}
			}
		}
    }
    
    public static void main(String args[]) {

        
//        BeingWatched bw = new BeingWatched();
//        Watcher w = new Watcher();
//        bw.addObserver(w);
//        bw.counter(200);
        
	}
}