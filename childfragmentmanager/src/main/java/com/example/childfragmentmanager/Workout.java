package com.example.childfragmentmanager;

public class Workout {
     private String name;
     private String description;

     public static final Workout[] workouts = {
             new Workout("The Limb loosener", "5 Handstand push-ups\n10 1-Legged squats\n15 Pull ups"),
             new Workout("Core Agony", "100 Pull ups\n50 Squats\n100 Sit-ups"),
             new Workout("The Wimp Special", "5 Pull-ups\n10 Push-ups\n15 Squats"),
             new Workout("Strength and Length", "500 meter runs\n20 x Pull ups\n20 Pood kettlball swing")
     };

     private Workout(String name, String desc){
         this.name = name;
         this.description = desc;
     }

     public String getDescription(){
         return description;
     }
     public String getName(){
         return name;
     }

    @Override
    public String toString() {
        return "Workout{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
