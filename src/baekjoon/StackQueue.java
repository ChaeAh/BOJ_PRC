package baekjoon;

import java.util.Stack;

public class StackQueue {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		
		queue.inQueue(1);
		queue.inQueue(2);
//		System.out.println(queue.outQueue() + " 1 2 번째");
		
		queue.inQueue(3);
//		System.out.println(queue.outQueue() + "3번째 하구");
//		System.out.println(queue.outQueue() + "마지막");
	}
	
	 static class MyQueue{
	        Stack inqueue;
	        Stack outqueue;
	         
	        MyQueue(){
	            this.inqueue = new Stack<>();
	            this.outqueue = new Stack<>();
	             
	        }
	         
	        void inQueue(int v){
	            inqueue.add(v);
	             
	        }
	         
	        int outQueue(){
	            if(outqueue.isEmpty())//** point **
	            while(!inqueue.isEmpty()){
	                outqueue.add(inqueue.pop());
	            }
	            return (int) outqueue.pop();
	        }
	         
	         
	    }
	
}
