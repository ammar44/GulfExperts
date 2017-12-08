package com.example.shaba.gulfexperts;

import java.util.ArrayList;

/**
 * Created by shaba on 2017-10-31.
 */

public class DataService {

    private static final DataService ourInstance = new DataService();
   static ArrayList<Exper> list = new ArrayList<>() ; ;
    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {


    }
    public ArrayList<Exper> getFeaturedStations() {

        // pretend we just downloaded featured stations from internet
      // (int id , String name , String major, String minor , String country, String work , String qualification )

        list.add(new Exper(1,"abdullah" , "Education" ,"Science" , "KSA","School" ,"PHD"));

        list.add(new Exper(2,"ahmed" , "Islamic Studies" ,"History" , "UAE" ,"University" ,"Master" ));
        //2
        list.add(new Exper(3,"saad" , "Art" ,"Drawing" , "Bahrin" ,"Company" ,"PHD" ));
        //3
        list.add(new Exper(4,"fahd" , "Law" ,"Judge" , "Oman" ,"Government" ,"Master" ));
        //4
        list.add(new Exper(5,"ali" , "Sport" ,"BasketBall" , "Kwit" ,"Team" ,"Non"));
//        //5
//        list.add(new Expert(6,"the_godfather" , "The Godfather" ,"/rPdtLWNsZmAtoZl9PK7S2wE3qiS.jpg" , "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito " +
//                "Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge." ,"63.443906" ,"1972-03-14" , false));
////6
//        list.add(new Expert(7,"heart_beat" , "In a Heartbeat" ,"/wJUJROdLOtOzMixkjkx1aaZGSLl.jpg" , "TA closeted boy runs the risk of " +
//                "being outed by his own heart after it pops out of his chest to chase down the boy of his dreams." ,"24.037071" ,"2017-06-01" , false));
////7
//        list.add(new Expert(8,"black_mirror" , "Black Mirror: White Christmas" ,"/he609rnU3tiwBjRklKNa4n2jQSd.jpg" , "This feature-length special consists of three interwoven stories. In a mysterious and remote snowy outpost, Matt and Potter share a Christmas meal, " +
//                "swapping creepy tales of their earlier lives in the outside world. Matt is a charismatic American trying to bring the reserved, secretive Potter out of" +
//                " his shell. But are both men who they appear to be? A woman gets thrust into a nightmarish world of 'smart' gadgetry. Plus a look at what would happen if you could 'block' people in real life" ,"27.929127" ,"2014-12-16", false ));
////8
//        list.add(new Expert(9,"schindlers" , "Schindler's Lit" ,"/yPisjyLweCl1tbgwgtzBCNCBle.jpg" , "The true story of how businessman Oskar Schindler saved over a thousand Jewish lives from the Nazis while they worked as slaves in his factory during World War II." ,"75.620965" ,"1993-11-29", false ));
////9
//        list.add(new Expert(10,"thriller" , "Michael Jackson's Thriller" ,"/puLSRxaG8MweynoRt8wZS8ZXZRM.jpg" , "A night at the movies turns into a " +
//                "nightmare when Michael and his date are attacked by a hoard of bloody-thirsty zombies." ,"2.494553" ,"1983-12-02" , false));
////10
//        list.add(new Expert(11,"spirited_away" , "Spirited Away" ,"/ynXoOxmDHNQ4UAy0oU6avW71HVW.jpg" , "A ten year old girl who wanders away from her parents along a path that leads to a world ruled by strange and unusual monster-like animals." +
//                " Her parents have been changed into pigs along with others inside a bathhouse full of these creatures. Will she ever see the world how it once was?" ,"85.977544" ,"2001-07-20" , false));
////11
//        list.add(new Expert(12,"whiplash" , "Whiplash" ,"/lIv1QinFqz4dlp5U4lQ6HaiskOZ.jpg" , "Under the direction of a ruthless instructor, " +
//                "a talented young drummer begins to pursue perfection at any cost, even his humanity." ,"139.651212" ,"2014-10-10" , false));
////12
//        list.add(new Expert(13,"godfather_ii" , "The Godfather: Part II" ,"/bVq65huQ8vHDd1a4Z37QtuyEvpA.jpg" , "In the continuing saga of the Corleone crime family, a young Vito Corleone grows up in Sicily and in 1910s New York. In the 1950s," +
//                " Michael Corleone attempts to expand the family business into Las Vegas, Hollywood and Cuba" ,"76.566383" ,"1974-12-20", false ));
////13
//        list.add(new Expert(14,"fight_club" , "Fight Club" ,"/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg" , "A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on" +
//                ", with underground \\\"fight clubs\\\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion." ,"105.826708" ,"1999-10-15", false ));
////14
//        list.add(new Expert(15,"life_is_beautiful" , "Life Is Beautiful" ,"/f7DImXDebOs148U4uPjI61iDvaK.jpg" , "A touching story of an Italian book seller of Jewish ancestry who lives in his own little fairy tale. His creative and happy life would come to an abrupt halt when" +
//                " his entire family is deported to a concentration camp during World War II. While locked up he tries to convince his son that the whole thing is just a game" ,"72.644976" ,"1997-12-20", false ));
////15
//        list.add(new Expert(16,"pulp_fiction" , "Pulp Fiction" ,"/dM2w364MScsjFf8pfMbaWUcWrR.jpg" , "A burger-loving hit man, his philosophical partner, a drug-addled gangster's moll and a washed-up boxer converge in this sprawling, comedic crime caper." +
//                " Their adventures unfurl in three stories that ingeniously trip back and forth in time." ,"87.75934" ,"1994-10-08" , false));
////16
//        list.add(new Expert(17,"doctor_who" , "Doctor Who: The Day of the Doctor" ,"/lQy2QVcacuH55k37K9Ox0gw3YpZ.jpg" , "In 2013, something terrible is awakening in London's National Gallery; in 1562, a murderous plot is afoot in Elizabethan England; and somewhere in space" +
//                "an ancient battle reaches its devastating conclusion. All of reality is at stake as the Doctor's own dangerous past comes back to haunt him." ,"28.290031" ,"2013-11-23" , false));
////17
//        list.add(new Expert(18,"dark_knight" , "The Dark Knight" ,"/1hRoyzDtpgMU7Dz4JF22RANzQO7.jpg" , "Batman raises the stakes in his war on crime. With the help of Lt. Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the" +
//                " remaining criminal organizations that plague the streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos " +
//                "unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as the Joker." ,"134.802091" ,"2008-07-16", false ));
////18
//        list.add(new Expert(19,"one_flow" , "One Flew Over the Cuckoo's Nest" ,"/2Sns5oMb356JNdBHgBETjIpRYy9.jpg" , "TWhile serving time for insanity at a state mental hospital, implacable rabble-rouser, Randle Patrick McMurphy inspires his fellow patients to rebel against" +
//                " the authoritarian rule of head nurse, Mildred Ratched" ,"92.089701" ,"1975-11-18" , false));
////19
//        list.add(new Expert(20,"tokyo_story" , "Tokyo Story" ,"/mMlPycVtj0bYZvTBpHe5BpVBk2S.jpg" , "An old couple visit their children and grandchildren in the city," +
//                " but the children have little time for them.." ,"24.391747" ,"1953-11-03" , false));
////20
//        list.add(new Expert(21,"tokyo_story" , "Tokyo Story" ,"/yPisjyLweCl1tbgwgtzBCNCBle.jpg" , "When larcenous real estate clerk Marion Crane goes on the lam with a wad of cash and hopes of starting a new life, she ends up at the notorious Bates" +
//                " Motel, where manager Norman Bates cares for his housebound mother. The place seems quirky, but fine… until Marion decides to take a shower" ," 67.477047" ,"1960-06-16" , false));
//
////21
//        list.add(new Expert(22,"sherlock" , "Sherlock: The Final Problem" ,"/ySiqbi1sW7imVYbtECZS0xQ3Hmj.jpg" , "Long buried secrets finally come to light as someone has been playing a very long game indeed. Sherlock and John face their greatest ever challenge." +
//                " Is the game finally over?" ,"27.307312" ,"2017-01-15" , false));
////22
//        list.add(new Expert(23,"minions" , "Minions" ,"/q0R4crx2SehcEEQEkYObktdeFy.jpg" , "Minions Stuart, Kevin and Bob are recruited by Scarlet Overkill, a super-villain who, alongside her inventor husband Herb, hatches a plot to take over " +
//                "the world" ,"871.675366" ,"2015-06-17" , false));
//
//        //23
//        list.add(new Expert(24,"beauty_and_the_east" , "Beauty and the Beast" ,"/tWqifoYuwLETmmasnGHO7xBjEtt.jpg" , "A live-action adaptation of Disney's version of the classic 'Beauty and the Beast' tale of a cursed prince and a beautiful young woman who helps him " +
//                "break the spell." ," 666.343766" ,"2017-03-16" , false));
////24
//        list.add(new Expert(25,"_interstellar" , "Interstellar" ,"/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg" , "Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space " +
//                "travel and conquer the vast distances involved in an interstellar voyage." ,"518.319846" ,"2014-11-05" , false));
//
//        //25
//        list.add(new Expert(26,"guardians" , "Guardians of the Galaxy" ,"/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg" , "Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan" +
//                " the Accuser." ,"498.164161" ,"2014-07-30" , false));
        return  list ;
    }

    public static void DeletMovie (Exper movie) {

        list.remove(movie) ;

    }

    public static int getlistSize(){

        return list.size();
    }

    public static Exper getMovie(int i){
        return list.get(i) ;

    }


}
