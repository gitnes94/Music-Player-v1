package org.example;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        String filePath = "C:\\Users\\Younes\\IdeaProjects\\MusicPlayer\\src\\main\\java\\org\\example\\Down The Rabbit Hole.wav";
        File file = new File(filePath);

        try(Scanner scanner = new Scanner(System.in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();

            String response = "";

            while(!response.equals("Q")){
                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");
                System.out.println("Enter your choice!");

                response = scanner.next().toUpperCase();

                switch(response){
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setFramePosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Wrong choice!");
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (LineUnavailableException e) {
            System.out.println("Audio Line Unavailable");
        }
        catch (UnsupportedAudioFileException e){
            System.out.println("Unsupported Audio File");
        }
        catch (IOException e) {
            System.out.println("Error");
        }
        finally{
            System.out.println("Closing");

        }
    }
}