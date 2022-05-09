package com.company;

public class Monster extends Dungeon {

    public Monster(String type) {
        set_initLocation(type);
    }

    //Monster types: "Chimera", "Ghoul", "Skeleton", "Ghost", "Imp", "Giant Spider", "Giant Snake"
    public void description(String type){
        switch (type){
            case "Chimera":
                System.out.println("\n===============================================================================================================================================================================");
                System.out.println("\nAs you move towards the next room, a giant Chimera leaps between you and the room`s opening! Without any hesitation the beast charges at you, clawing and biting at your torso. \nYou are mauled to death...");
                System.out.println("\nGAMEOVER");
                System.out.println("\n===============================================================================================================================================================================");
                break;
            case "Ghoul":
                System.out.println("\n==========================================================================================================================================================================");
                System.out.println("\nAs you move towards the next room, a rotten Ghoul emerges from a pile of rotten bodies at the corner of the dungeon room! It rapidly spews an acid gunk from its stomach! \nYou are corroded to death...");
                System.out.println("\nGAMEOVER");
                System.out.println("\n==========================================================================================================================================================================");
                break;
            case "Skeleton":
                System.out.println("\n================================================================================================================================================================================");
                System.out.println("\nAs you move towards the next room, a creepy animated Skeleton emerges from a pile of bones in the dungeon room! It move towards you with unnatural speed and bites your throat! \nYou bleed to death...");
                System.out.println("\nGAMEOVER");
                System.out.println("\n================================================================================================================================================================================");
                break;
            case "Ghost":
                System.out.println("\n===================================================================================================================================================================================");
                System.out.println("\nAs you move towards the next room, a Ghost seems to appear from thin air in front of you! Resolve faults you as it approaches! Once near, it merges with your flesh possessing you! \nYou go mad and remain in the dwellings of the dungeon for the rest of your days. You starve to death...");
                System.out.println("\nGAMEOVER");
                System.out.println("\n===================================================================================================================================================================================");
                break;
            case "Imp":
                System.out.println("\n==============================================================================================================================================================================================================");
                System.out.println("\nAs you move towards the next room, a ghastly Imp cackles in the shadows of the next dungeon room! As you turn around to avoid the encounter, a swarm of small Imps start striking you with crude wooden poles! \nYou are impaled to death...");
                System.out.println("\nGAMEOVER");
                System.out.println("\n==============================================================================================================================================================================================================");
                break;
            case "Giant Spider":
                System.out.println("\n===================================================================================================================================================");
                System.out.println("\nAs you move towards the next room, a Giant Spider drops from the dungeon ceiling striking you with its fangs! The bite carries a most toxic venom. \nYour bodily functions stop and you are poisoned to death...");
                System.out.println("\nGAMEOVER");
                System.out.println("\n===================================================================================================================================================");
                break;
            case "Giant Snake":
                System.out.println("\n=============================================================================================================================================================================");
                System.out.println("\nAs you move towards the next room, a Giant Snake strikes you with awesome speed! As you fall, shocked from the blow, the giant serpent wraps its slithering body around you. \nYou are crushed to death...");
                System.out.println("\nGAMEOVER");
                System.out.println("\n=============================================================================================================================================================================");
                break;

            default:
                System.out.println("\nYou die of unknown causes...");
        }
    }

}
