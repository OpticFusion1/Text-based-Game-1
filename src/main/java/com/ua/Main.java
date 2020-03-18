package com.ua;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] monsters = {"Ogre", "Troll", "Mummy", "Zombie", "Werewolf", "Vampire"};

        int maxMonsterHealth = 75;
        int monsterAttackDamage = 25;

        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;

        boolean running = true;

        System.out.println("Welcome to the dungeon!");
        GAME:
        while (running) {

            System.out.println("---------------------------------------------");

            int monsterHealth = random.nextInt(maxMonsterHealth);
            String monster = monsters[random.nextInt(monsters.length)];

            System.out.println("\t# " + monster + " appeared! #\n");
            while (monsterHealth > 0) {
                System.out.println("\t Your HP: " + health);
                System.out.println("\t " + monster + "'s HP: " + monsterHealth);
                System.out.println("\n\t What would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run");

                String input = sc.nextLine();

                if (input.equals("1")) {
                    int damageDealt = random.nextInt(attackDamage);
                    int damageTaken = random.nextInt(monsterAttackDamage);

                    monsterHealth -= damageDealt;
                    health -= damageTaken;
                    System.out.println("\t You strike the " + monster + " for " + damageDealt + " damage.");
                    System.out.println("\t You receive " + damageTaken + " in retaliation! ");

                    if (health < 1) {
                        System.out.println("\t You have taken to much damage");
                        break;
                    }
                } else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t You drink a health potion, healing yourself for " + healthPotionHealAmount + "."
                                + "\n\t You now have " + health + " HP."
                                + "\n\t You have " + numHealthPotions + " health potions left.\n");
                    } else {
                        System.out.println("\t You have no health potions left! Defeat enemies for a chance to get one!\n");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\t You run away from the " + monster + "!");
                    continue GAME;

                } else {
                    System.out.println("\t Invalid command! ");
                }
            }

            if (health < 1) {
                System.out.println("You limp out of the dungeon, you are weak from the battle!");
                break;
            }
            System.out.println("--------------------------------------------");
            System.out.println(" # " + monster + " was defeated! # ");
            System.out.println(" # You have " + health + " HP left. #");
            if (random.nextInt(100) > healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + monster + " dropped health potion! # ");
                System.out.println(" # You now have " + numHealthPotions + " health potion(s). # ");
            }

            System.out.println("---------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = sc.nextLine();
            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = sc.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("You continue your adventure!");
            } else if (input.equals("2")) {
                System.out.println("You exit the dungeon, successful from your adventure!");
                break;
            }
        }
        System.out.println("#######################");
        System.out.println("# THANKS FOR PLAYING! #");
        System.out.println("#######################");
    }
}
