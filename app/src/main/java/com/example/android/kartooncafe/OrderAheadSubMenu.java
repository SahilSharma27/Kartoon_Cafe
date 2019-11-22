package com.example.android.kartooncafe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAheadSubMenu extends AppCompatActivity {
    public static ArrayList<Cart> reservationCart = new ArrayList<>();
    Customizables veg;
    Customizables veg1;
    Customizables grilledVeg;
    Customizables nonveg;
    Customizables nonveg1;
    Customizables nonveg2;
    Customizables nonveg3;
    Customizables nonveg4;
    Customizables nonveg5;
    Customizables nonveg6;
    Customizables nonveg7;
    Customizables nonveg8;
    Customizables nonveg9;
    Customizables chk;
    Customizables chk1;
    Customizables chk2;
    Customizables chk3;
    Customizables chk4;
    Customizables chk5;
    Customizables mutton;
    Customizables prawn;
    Customizables prawn1;
    Customizables prawn2;
    Customizables prawn3;
    Customizables lamb;
    Customizables butterscotch;
    Customizables seafood;
    Customizables seafood1;
    Customizables vanilla;
    Customizables strawberry;
    Customizables chocolate;
    Customizables coffee;
    Customizables belgianChocolate;
    Customizables mocha;
    Customizables plate1;
    Customizables plate2;
    Customizables plate3;
    Customizables classic;
    Customizables multigrain;
    Customizables grilledChicken;
    Customizables chikensalad;
    Customizables cheeseandham;
    Customizables crispy;
    Customizables fluffy;
    Customizables plain;
    Customizables egg;
    Customizables mushroom;
    Customizables mongolianstyle;
    Customizables shanghaistyle;
    Customizables cheese;
    ImageView menuBackView;
    ArrayList<Item> menu1;
    ArrayList<Item> menu2;
    ArrayList<Item> menu3;
    ArrayList<Item> menu4;
    ArrayList<Item> menu5;
    ArrayList<Item> menu6;
    ArrayList<Item> menu7;
    ArrayList<Item> menu8;
    ArrayList<Item> menu9;
    ArrayList<Item> menu10;
    ArrayList<Item> menu11;
    ArrayList<Item> menu12;
    ArrayList<Item> menu13;
    ArrayList<Item> menu14;
    ArrayList<Item> menu15;
    ArrayList<Item> menu16;
    ArrayList<Item> menu17;
    ArrayList<Item> menu18;
    ArrayList<Item> menu19;
    ArrayList<Item> menu20;
    ArrayList<Item> clickedMenu = new ArrayList<>();
    RecyclerView orderAheadSubMenuRCView;
    CustomAdapter2A adapter2;
    //   Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_ahead_sub_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        menuBackView = findViewById(R.id.order_ahead_menu_back);
        orderAheadSubMenuRCView = findViewById(R.id.order_ahead_sub_menu_rcv);
        //button1=findViewById(R.id.cartbutton);


        Intent intent = getIntent();
        int menuBackdropId = intent.getIntExtra("id", 0);
        String menuTitle = intent.getStringExtra("title");
        String menuCategory = intent.getStringExtra("category");


        getSupportActionBar().setTitle(menuTitle);
        menuBackView.setImageResource(menuBackdropId);
        loadCustoms();

        if (menuCategory.equals("juices")) {
            menu1 = new ArrayList<>();
            loadMenu1();
            clickedMenu.clear();
            clickedMenu.addAll(menu1);

        } else if (menuCategory.equals("shakes")) {
            menu2 = new ArrayList<>();
            loadMenu2();
            clickedMenu.clear();
            clickedMenu.addAll(menu2);
        } else if (menuCategory.equals("coffee")) {
            menu3 = new ArrayList<>();
            loadMenu3();
            clickedMenu.clear();
            clickedMenu.addAll(menu3);
        } else if (menuCategory.equals("salads")) {
            menu4 = new ArrayList<>();
            loadMenu4();
            clickedMenu.clear();
            clickedMenu.addAll(menu4);
        } else if (menuCategory.equals("drinks")) {
            menu5 = new ArrayList<>();
            loadMenu5();
            clickedMenu.clear();
            clickedMenu.addAll(menu5);
        } else if (menuCategory.equals("foodcrunches")) {
            menu6 = new ArrayList<>();
            loadMenu6();
            clickedMenu.clear();
            clickedMenu.addAll(menu6);
        } else if (menuCategory.equals("croissants")) {
            menu7 = new ArrayList<>();
            loadMenu7();
            clickedMenu.clear();
            clickedMenu.addAll(menu7);
        } else if (menuCategory.equals("breakfast")) {
            menu8 = new ArrayList<>();
            loadMenu8();
            clickedMenu.clear();
            clickedMenu.addAll(menu8);
        } else if (menuCategory.equals("soups")) {
            menu9 = new ArrayList<>();
            loadMenu9();
            clickedMenu.clear();
            clickedMenu.addAll(menu9);
        } else if (menuCategory.equals("starters")) {
            menu10 = new ArrayList<>();
            loadMenu10();
            clickedMenu.clear();
            clickedMenu.addAll(menu10);
        } else if (menuCategory.equals("burgers")) {
            menu11 = new ArrayList<>();
            loadMenu11();
            clickedMenu.clear();
            clickedMenu.addAll(menu11);
        } else if (menuCategory.equals("pizza")) {
            menu12 = new ArrayList<>();
            loadMenu12();
            clickedMenu.clear();
            clickedMenu.addAll(menu12);
        } else if (menuCategory.equals("pasta")) {
            menu13 = new ArrayList<>();
            loadMenu13();
            clickedMenu.clear();
            clickedMenu.addAll(menu13);
        } else if (menuCategory.equals("mexico")) {
            menu14 = new ArrayList<>();
            loadMenu14();
            clickedMenu.clear();
            clickedMenu.addAll(menu14);
        } else if (menuCategory.equals("dimsums")) {
            menu15 = new ArrayList<>();
            loadMenu15();
            clickedMenu.clear();
            clickedMenu.addAll(menu15);
        } else if (menuCategory.equals("parade")) {
            menu16 = new ArrayList<>();
            loadMenu16();
            clickedMenu.clear();
            clickedMenu.addAll(menu16);
        } else if (menuCategory.equals("platter")) {
            menu17 = new ArrayList<>();
            loadMenu17();
            clickedMenu.clear();
            clickedMenu.addAll(menu17);
        } else if (menuCategory.equals("chinese")) {
            menu18 = new ArrayList<>();
            loadMenu18();
            clickedMenu.clear();
            clickedMenu.addAll(menu18);
        } else if (menuCategory.equals("arabic")) {
            menu19 = new ArrayList<>();
            loadMenu19();
            clickedMenu.clear();
            clickedMenu.addAll(menu19);
        } else if (menuCategory.equals("desserts")) {
            menu20 = new ArrayList<>();
            loadMenu20();
            clickedMenu.clear();
            clickedMenu.addAll(menu20);
        }


        orderAheadSubMenuRCView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        orderAheadSubMenuRCView.setLayoutManager(linearLayoutManager);

        adapter2 = new CustomAdapter2A(this, clickedMenu);
        orderAheadSubMenuRCView.setAdapter(adapter2);


    }

    public void loadMenu1() {
        ArrayList<Customizables> defaultCust = new ArrayList<>();


        menu1.add(new Item("CPJ1", "Bubbles Watermelon", getString(R.string.juice1), 0, 110.0, 0, defaultCust));
        menu1.add(new Item("CPJ2", "Blossom Apple", getString(R.string.juice2), 0, 110.0, 0, defaultCust));
        menu1.add(new Item("CPJ3", "Buttercup Mango", getString(R.string.juice3), 0, 110.0, 0, defaultCust));
        menu1.add(new Item("CPJ4", "Classic Mojito", getString(R.string.juice4), 0, 110.0, 0, defaultCust));
        menu1.add(new Item("CPJ5", "Watermelon Mojito", getString(R.string.juice5), 0, 110.0, 0, defaultCust));
        menu1.add(new Item("CPJ6", "Cinderella Fresh Ginger ale", getString(R.string.juice6), 0, 110.0, 0, defaultCust));
        menu1.add(new Item("CPJ7", "Blue Lagoon", getString(R.string.juice7), 0, 110.0, 0, defaultCust));
        menu1.add(new Item("CPJ8", "Daisy Duck Iced Tea", getString(R.string.juice8), 0, 110.0, 0, defaultCust));
        menu1.add(new Item("CPJ9", "Donald Duck Fresh Lime Soda", getString(R.string.juice9), 0, 110.0, 0, defaultCust));
        menu1.add(new Item("CPJ10", "Virgin Mary", getString(R.string.juice10), 0, 110.0, 0, defaultCust));
        menu1.add(new Item("CPJ11", "Masala Soft Drink", getString(R.string.juice11), 0, 110.0, 0, defaultCust));

    }

    public void loadMenu2() {
        ArrayList<Customizables> menu2custItem1 = new ArrayList<>();
        menu2custItem1.add(vanilla);
        menu2custItem1.add(strawberry);
        menu2custItem1.add(chocolate);


        ArrayList<Customizables> menu2custItem3 = new ArrayList<>();
        menu2custItem3.add(vanilla);
        menu2custItem3.add(coffee);
        menu2custItem3.add(belgianChocolate);


        ArrayList<Customizables> defaultCust = new ArrayList<>();


        menu2.add(new Item("SHK1", "Ratatouille Classic Shakes", getString(R.string.shake1), 0, 190, 1, menu2custItem1));
        menu2.add(new Item("SHK2", "Johny Bravo Banoffee Shake", getString(R.string.shake2), 0, 220, 0, defaultCust));
        menu2.add(new Item("SHK3", "Snow-White Oreo Donut Shake", getString(R.string.shake3), 0, 205, 1, menu2custItem3));
        menu2.add(new Item("SHK4", "ET Mango Cream Shake", getString(R.string.shake4), 0, 195, 0, defaultCust));
        menu2.add(new Item("SHK5", "Betty Boo Brownie Shake with brownie", getString(R.string.shake5), 0, 280, 0, defaultCust));
        menu2.add(new Item("SHK6", "Belle Strawberry Cheesecake Shake", getString(R.string.shake6), 0, 290, 0, defaultCust));

    }

    public void loadMenu3() {
        ArrayList<Customizables> defaultCust = new ArrayList<>();


        menu3.add(new Item("CFE1", "Batman Americano Black Coffee", "", 0, 110, 0, defaultCust));
        menu3.add(new Item("CFE2", "Goofy Grainy Cappucino", "", 0, 115, 0, defaultCust));
        menu3.add(new Item("CFE3", "Pluto Moccha", "", 0, 125, 0, defaultCust));
        menu3.add(new Item("CFE4", "Garfield Latte", "", 0, 130, 0, defaultCust));
        menu3.add(new Item("CFE5", "Scooby Doo Cold Coffee", "", 0, 150, 0, defaultCust));
        menu3.add(new Item("CFE6", "Thor Detox Green Tea", "", 0, 120, 0, defaultCust));

    }

    public void loadMenu4() {
        ArrayList<Customizables> menu4custItem2 = new ArrayList<>();
        menu4custItem2.add(veg);
        menu4custItem2.add(chk);

        ArrayList<Customizables> defaultCust = new ArrayList<>();


        menu4.add(new Item("SLD1", "Professor X Chicken Salad", getString(R.string.salad1), 1, 240, 0, defaultCust));
        menu4.add(new Item("SLD2", "Hercules Quinoa Salad", getString(R.string.salad2), 2, 240, 1, menu4custItem2));
        menu4.add(new Item("SLD3", "Fruit Salad", getString(R.string.salad3), 1, 240, 0, defaultCust));
        menu4.add(new Item("SLD4", "Egg Salad", getString(R.string.salad4), 1, 240, 0, defaultCust));
    }

    public void loadMenu5() {
        ArrayList<Customizables> menu5custItem1 = new ArrayList<>();
        menu5custItem1.add(vanilla);
        menu5custItem1.add(strawberry);
        menu5custItem1.add(chocolate);
        menu5custItem1.add(mocha);
        menu5custItem1.add(butterscotch);

        ArrayList<Customizables> defaultCust = new ArrayList<>();


        menu5.add(new Item("BPD1", "Captain America Whey Protein Shake", getString(R.string.drink1), 0, 250, 1, menu5custItem1));
        menu5.add(new Item("BPD2", "Rick & Morty's Peanut Butter Shake", getString(R.string.drink2), 0, 230, 0, defaultCust));
        menu5.add(new Item("BPD3", "Minions Banana Shake", getString(R.string.drink3), 0, 200, 0, defaultCust));
        menu5.add(new Item("BPD4", "Buttermilk", getString(R.string.drink4), 0, 150, 0, defaultCust));
        menu5.add(new Item("BPD5", "Mixed Fruit Shake (Blend of Fruits & Berries)", getString(R.string.drink5), 0, 150, 0, defaultCust));
    }

    public void loadMenu6() {

        ArrayList<Customizables> menu6cutItem2 = new ArrayList<>();
        menu6cutItem2.add(veg);
        menu6cutItem2.add(chk3);
        ArrayList<Customizables> menu6cutItem4 = new ArrayList<>();
        menu6cutItem4.add(veg);
        menu6cutItem4.add(chk4);
        ArrayList<Customizables> menu6cutItem5 = new ArrayList<>();
        menu6cutItem5.add(plate1);
        menu6cutItem5.add(plate2);
        menu6cutItem5.add(plate3);
        ArrayList<Customizables> menu6cutItem6 = new ArrayList<>();
        menu6cutItem6.add(veg);
        menu6cutItem6.add(chk);

        ArrayList<Customizables> menu6cutItem7 = new ArrayList<>();
        menu6cutItem7.add(veg);
        menu6cutItem7.add(chk);
        ArrayList<Customizables> defaultCust = new ArrayList<>();


        menu6.add(new Item("FCR1", "Special Oat Grilled Fish", getString(R.string.crunch1), 1, 500, 0, defaultCust));
        menu6.add(new Item("FCR2", "Snoopy's Whole Wheat Pizza", getString(R.string.crunch2), 2, 500, 1, menu6cutItem2));
        menu6.add(new Item("FCR3", "Peri Peri Chicken Wings/Paneer", getString(R.string.crunch3), 1, 500, 0, defaultCust));
        menu6.add(new Item("FCR4", "Whole Wheat Pasta", getString(R.string.crunch4), 2, 500, 1, menu6cutItem4));
        menu6.add(new Item("FCR5", "Jasmine Pita with Hummus", getString(R.string.crunch5), 1, 500, 1, menu6cutItem5));
        menu6.add(new Item("FCR6", "Whole Wheat Dimsums", getString(R.string.crunch6), 2, 500, 1, menu6cutItem6));
        menu6.add(new Item("FCR7", "Whole Wheat Grilled Sandwich", getString(R.string.crunch7), 2, 500, 1, menu6cutItem7));
        menu6.add(new Item("FCR8", "Oats Pancakes", getString(R.string.crunch8), 0, 500, 0, defaultCust));
        menu6.add(new Item("FCR9", "Grilled Chicken", getString(R.string.crunch9), 1, 500, 0, defaultCust));
    }

    public void loadMenu7() {
        ArrayList<Customizables> menu7custItem1 = new ArrayList<>();
        menu7custItem1.add(classic);
        menu7custItem1.add(multigrain);
        ArrayList<Customizables> menu7custItem2 = new ArrayList<>();
        menu7custItem2.add(grilledVeg);
        menu7custItem2.add(chikensalad);
        menu7custItem2.add(cheeseandham);
        ArrayList<Customizables> defaultCust = new ArrayList<>();
        menu7.add(new Item("CRST1", "Utterly Butterly Delicious Layered", getString(R.string.croissants1), 2, 180, 1, menu7custItem1));
        menu7.add(new Item("CRST2", "Pumbaa Stuffed Croissant", getString(R.string.croissants2), 2, 110, 1, menu7custItem2));
        menu7.add(new Item("CRST3", "Chip and Dale Chocolate Croissant", getString(R.string.croissants3), 0, 175, 0, defaultCust));
    }

    public void loadMenu8() {
        ArrayList<Customizables> defautCust = new ArrayList<>();

        menu8.add(new Item("BRFS1", "Chipmunks Waffles with Nuts", getString(R.string.breakfast1), 0, 150, 0, defautCust));
        menu8.add(new Item("BRFS2", "Mrs. Jombo Pan Cakes", getString(R.string.breakfast2), 0, 210, 0, defautCust));
        menu8.add(new Item("BRFS3", "Belle's Special", getString(R.string.breakfast3), 0, 145, 0, defautCust));
        menu8.add(new Item("BRFS4", "Mickey loves Omlette", getString(R.string.breakfast4), 0, 190, 0, defautCust));
        menu8.add(new Item("BRFS5", "Minnie loves it French Toast Style", getString(R.string.breakfast5), 0, 210, 0, defautCust));
    }

    public void loadMenu9() {
        ArrayList<Customizables> defautCust = new ArrayList<>();
        ArrayList<Customizables> menu9custItem3 = new ArrayList<>();
        menu9custItem3.add(veg);
        menu9custItem3.add(nonveg1);
        ArrayList<Customizables> menu9custItem4 = new ArrayList<>();
        menu9custItem4.add(veg);
        menu9custItem4.add(nonveg1);
        ArrayList<Customizables> menu9custItem6 = new ArrayList<>();
        menu9custItem6.add(veg);
        menu9custItem6.add(nonveg1);
        ArrayList<Customizables> menu9custItem7 = new ArrayList<>();
        menu9custItem7.add(veg);
        menu9custItem7.add(nonveg2);
        menu9custItem7.add(prawn);


        menu9.add(new Item("SSLD1", "Tomatina Soup", getString(R.string.soup1), 2, 145, 0, defautCust));
        menu9.add(new Item("SSLD2", "Junglee Mushroom Soup (tamed by our chef)", getString(R.string.soup2), 2, 175, 0, defautCust));
        menu9.add(new Item("SSLD3", "Dory Lemon Coriander Soup", getString(R.string.soup3), 2, 145, 1, menu9custItem3));
        menu9.add(new Item("SSLD4", "Mario Manchow Soup", getString(R.string.soup4), 2, 155, 1, menu9custItem4));
        menu9.add(new Item("SSLD5", "Dolittle Chicken Soup", getString(R.string.soup5), 2, 190., 0, defautCust));
        menu9.add(new Item("SSLD6", "Popeye Green Salad", getString(R.string.soup6), 2, 190, 1, menu9custItem6));
        menu9.add(new Item("SSLD7", "Noddy Caesar Salad", getString(R.string.soup7), 2, 190, 1, menu9custItem7));
    }

    public void loadMenu10() {
        ArrayList<Customizables> menu10custitem1 = new ArrayList<>();
        menu10custitem1.add(veg);
        menu10custitem1.add(nonveg3);
        ArrayList<Customizables> menu10custitem2 = new ArrayList<>();
        menu10custitem2.add(plain);
        menu10custitem2.add(veg1);
        menu10custitem2.add(nonveg5);
        ArrayList<Customizables> menu10custitem3 = new ArrayList<>();
        menu10custitem3.add(veg);
        menu10custitem3.add(nonveg6);
        ArrayList<Customizables> menu10custitem6 = new ArrayList<>();
        menu10custitem6.add(plain);
        menu10custitem6.add(egg);
        menu10custitem6.add(chk);
        ArrayList<Customizables> menu10custitem7 = new ArrayList<>();
        menu10custitem7.add(veg);
        menu10custitem7.add(egg);
        menu10custitem7.add(chk);
        ArrayList<Customizables> menu10custitem8 = new ArrayList<>();
        menu10custitem8.add(plain);
        menu10custitem8.add(cheese);

        ArrayList<Customizables> menu10custitem9 = new ArrayList<>();
        menu10custitem9.add(veg);
        menu10custitem9.add(chk);
        ArrayList<Customizables> defaultCust = new ArrayList<>();

        menu10.add(new Item("STRS1", "Mr. Bean Spring Roll", getString(R.string.starters1), 2, 210, 1, menu10custitem1));
        menu10.add(new Item("STRS2", "Jasmine Pita with Hummus", getString(R.string.starters2), 2, 280, 1, menu10custitem2));
        menu10.add(new Item("STRS3", "Tinker Bell Manchurian", getString(R.string.starters3), 2, 270, 1, menu10custitem3));
        menu10.add(new Item("STRS4", "Casper Crispy Honey Chilli Chicken", getString(R.string.starters4), 0, 280, 0, defaultCust));
        menu10.add(new Item("STRS5", "Simpsons Crispy Fried Chicken Wings or POPCORNS", getString(R.string.starters5), 0, 370, 0, defaultCust));
        menu10.add(new Item("STRS6", "Kung Fu Panda Fried Rice", getString(R.string.starters6), 2, 190, 1, menu10custitem6));
        menu10.add(new Item("STRS7", "Dragon Ball Z Noodles", getString(R.string.starters7), 2, 190, 1, menu10custitem7));
        menu10.add(new Item("STRS8", "The Incredibles Garlic Bread", getString(R.string.starters8), 2, 110, 1, menu10custitem8));
        menu10.add(new Item("STRS9", "Nuggets", getString(R.string.starters9), 2, 320, 1, menu10custitem9));
    }

    public void loadMenu11() {

        ArrayList<Customizables> defaultCust = new ArrayList<>();
        ArrayList<Customizables> menu11custItem4 = new ArrayList<>();
        menu11custItem4.add(veg);
        menu11custItem4.add(chk);

        ArrayList<Customizables> menu11custItem5 = new ArrayList<>();
        menu11custItem5.add(veg);
        menu11custItem5.add(chk);
        ArrayList<Customizables> menu11custItem6 = new ArrayList<>();
        menu11custItem6.add(veg);
        menu11custItem6.add(chk);

        menu11.add(new Item("BSDW1", "Ben10 Slurpy Veg Burger", getString(R.string.burger1), 0, 220, 0, defaultCust));
        menu11.add(new Item("BSDW2", "Jughead's favourite cheesy chicken burger", getString(R.string.burger2), 1, 270, 0, defaultCust));
        menu11.add(new Item("BSDW3", "Iron man eats Lamb Burger", getString(R.string.burger3), 1, 290, 0, defaultCust));
        menu11.add(new Item("BSDW4", "Archies Zingy Chicken Sandwich", getString(R.string.burger4), 2, 215, 1, menu11custItem4));
        menu11.add(new Item("BSDW5", "Croissant Sandwich", getString(R.string.burger5), 2, 220, 1, menu11custItem5));
        menu11.add(new Item("BSDW6", "Hearty Spider Club Sandwich", getString(R.string.burger6), 2, 280, 1, menu11custItem6));
    }

    public void loadMenu12() {
        ArrayList<Customizables> menu12custItem8 = new ArrayList<>();
        menu12custItem8.add(veg);
        menu12custItem8.add(nonveg7);
        ArrayList<Customizables> defaultCust = new ArrayList<>();

        menu12.add(new Item("PIZA1", "Jerry's handcrafted Plain cheese Pizza", getString(R.string.pizza1), 0, 350, 0, defaultCust));
        menu12.add(new Item("PIZA2", "Shrek's classic Margaritha Pizza", getString(R.string.pizza2), 0, 370, 0, defaultCust));
        menu12.add(new Item("PIZA3", "Tom's Zingy Red Pepper Pizza", getString(R.string.pizza3), 0, 400, 0, defaultCust));
        menu12.add(new Item("PIZA4", "Simba's smoked sausage Pizza", getString(R.string.pizza4), 1, 480, 0, defaultCust));
        menu12.add(new Item("PIZA5", "Avengers Peppery Pepperoni Pizza", getString(R.string.pizza5), 0, 650, 0, defaultCust));
        menu12.add(new Item("PIZA6", "Hulk Zesty Barbeque Chicken Pizza", getString(R.string.pizza6), 1, 600, 0, defaultCust));
        menu12.add(new Item("PIZA7", "Garlic Prawn Pizza", getString(R.string.pizza7), 1, 550, 0, defaultCust));
        menu12.add(new Item("PIZA8", "Superman Calzone", getString(R.string.pizza8), 2, 460, 1, menu12custItem8));
    }

    public void loadMenu13() {
        ArrayList<Customizables> menu13custItem1 = new ArrayList<>();
        menu13custItem1.add(veg);
        menu13custItem1.add(chk);
        menu13custItem1.add(prawn1);
        ArrayList<Customizables> menu13custItem2 = new ArrayList<>();
        menu13custItem2.add(veg);
        menu13custItem2.add(chk1);
        menu13custItem2.add(prawn2);
        ArrayList<Customizables> menu13custItem3 = new ArrayList<>();
        menu13custItem3.add(veg);
        menu13custItem3.add(chk1);
        menu13custItem3.add(prawn2);
        ArrayList<Customizables> menu13custItem4 = new ArrayList<>();
        menu13custItem4.add(veg);
        menu13custItem4.add(chk1);
        menu13custItem4.add(prawn3);
        ArrayList<Customizables> menu13custItem5 = new ArrayList<>();
        menu13custItem5.add(veg);
        menu13custItem5.add(chk);
        menu13custItem5.add(lamb);
        ArrayList<Customizables> menu13custItem6 = new ArrayList<>();
        menu13custItem6.add(mushroom);
        menu13custItem6.add(chk5);
        menu13custItem6.add(seafood);
        menu13.add(new Item("PST1", "Wonder Woman Arabiatta", getString(R.string.pasta1), 2, 240, 1, menu13custItem1));
        menu13.add(new Item("PST2", "Pink Panther loves Pink", getString(R.string.pasta2), 2, 280, 1, menu13custItem2));
        menu13.add(new Item("PST3", "Simpson creamy mushroom sauce", getString(R.string.pasta3), 2, 300, 1, menu13custItem3));
        menu13.add(new Item("PST4", "Flash says Bolognese", getString(R.string.pasta4), 2, 350, 1, menu13custItem4));
        menu13.add(new Item("PST5", "Three musketeers Infused Lasagne", getString(R.string.pasta5), 2, 340, 1, menu13custItem5));
        menu13.add(new Item("PST6", "Veronica's Rissotto", getString(R.string.pasta6), 2, 370, 1, menu13custItem6));
    }

    public void loadMenu14() {
        ArrayList<Customizables> menu14custitem1 = new ArrayList<>();
        menu14custitem1.add(veg);
        menu14custitem1.add(nonveg2);
        ArrayList<Customizables> menu14custitem2 = new ArrayList<>();
        menu14custitem2.add(veg);
        menu14custitem2.add(nonveg4);
        ArrayList<Customizables> menu14custitem3 = new ArrayList<>();
        menu14custitem3.add(veg);
        menu14custitem3.add(nonveg5);
        ArrayList<Customizables> defaultCust = new ArrayList<>();
        menu14.add(new Item("MIMX1", "Dwarfs Golden Enhchilada", getString(R.string.mexico1), 2, 280, 1, menu14custitem1));
        menu14.add(new Item("MIMX2", "Hello Kitty Grilled Quesadilla", getString(R.string.mexico2), 2, 260, 1, menu14custitem2));
        menu14.add(new Item("MIMX3", "Tin Tin Spicy Tacos", getString(R.string.mexico3), 2, 295, 1, menu14custitem3));
        menu14.add(new Item("MIMX4", "Stark Nachos", getString(R.string.mexico4), 2, 110, 0, defaultCust));
    }

    public void loadMenu15() {
        ArrayList<Customizables> defaultCust = new ArrayList<>();
        menu15.add(new Item("DIMS1", "Papa Smurf Original Veg", getString(R.string.dimsums1), 0, 150, 0, defaultCust));
        menu15.add(new Item("DIMS2", "Smurfette Lemongrass and Chilli", getString(R.string.dimsums2), 0, 170, 0, defaultCust));
        menu15.add(new Item("DIMS3", "Clumsy Smurf Corn and Spinach", getString(R.string.dimsums3), 0, 165, 0, defaultCust));
        menu15.add(new Item("DIMS4", "Grouchy Smurf Chicken Homemade", getString(R.string.dimsums4), 1, 190, 0, defaultCust));
        menu15.add(new Item("DIMS5", "Brainy Smurf Shredded Lamb", getString(R.string.dimsums5), 1, 220, 0, defaultCust));
    }

    public void loadMenu16() {
        ArrayList<Customizables> menu16custItem1 = new ArrayList<>();
        menu16custItem1.add(veg);
        menu16custItem1.add(nonveg8);
        ArrayList<Customizables> menu16custItem2 = new ArrayList<>();
        menu16custItem2.add(veg);
        menu16custItem2.add(nonveg8);
        ArrayList<Customizables> menu16custItem3 = new ArrayList<>();
        menu16custItem3.add(veg);
        menu16custItem3.add(seafood1);
        ArrayList<Customizables> menu16custItem9 = new ArrayList<>();
        menu16custItem9.add(mongolianstyle);
        menu16custItem9.add(shanghaistyle);
        ArrayList<Customizables> defaultCust = new ArrayList<>();

        menu16.add(new Item("PRD1", "Jafar Biryani", getString(R.string.parade1), 2, 280, 1, menu16custItem1));
        menu16.add(new Item("PRD2", "Goku Salut Sizzlers", getString(R.string.parade2), 2, 400, 1, menu16custItem2));
        menu16.add(new Item("PRD3", "Doremon Sushi", getString(R.string.parade3), 2, 640, 1, menu16custItem3));
        menu16.add(new Item("PRD4", "Nemo's Fish Cake", getString(R.string.parade4), 1, 550, 0, defaultCust));
        menu16.add(new Item("PRD5", "Tigger Kung Pao Chicken", getString(R.string.parade5), 1, 350, 0, defaultCust));
        menu16.add(new Item("PRD6", "Mermaid Fish & Chips", getString(R.string.parade6), 1, 500, 0, defaultCust));
        menu16.add(new Item("PRD7", "Sher Khan Chicken", getString(R.string.parade7), 1, 460, 0, defaultCust));
        menu16.add(new Item("PRD8", "Shizuka Pan Fried Prawns", getString(R.string.parade8), 1, 650, 0, defaultCust));
        menu16.add(new Item("PRD9", "Kochikame's Chinese Bowl", getString(R.string.parade9), 2, 350, 1, menu16custItem9));
    }

    public void loadMenu17() {
        ArrayList<Customizables> defaultCust = new ArrayList<>();
        ArrayList<Customizables> menu17custItem3 = new ArrayList<>();
        menu17custItem3.add(veg);
        menu17custItem3.add(nonveg5);
        menu17.add(new Item("PTP1", "Mougli Veg Platter", getString(R.string.platter1), 0, 370, 0, defaultCust));
        menu17.add(new Item("PTP2", "Bageera Fiery Non Veg Platter", getString(R.string.platter2), 1, 450, 0, defaultCust));
        menu17.add(new Item("PTP3", "Indian Small Platter", getString(R.string.platter3), 2, 250, 1, menu17custItem3));
        menu17.add(new Item("PTP4", "Non Veg Kabab Platter", getString(R.string.platter4), 1, 650, 0, defaultCust));
        menu17.add(new Item("PTP5", "Veg Kebab Platter", getString(R.string.platter5), 0, 450, 0, defaultCust));
    }

    public void loadMenu18() {
        ArrayList<Customizables> defaultCust = new ArrayList<>();
        ArrayList<Customizables> menu18custItem3 = new ArrayList<>();
        menu18custItem3.add(veg);
        menu18custItem3.add(nonveg9);
        menu18.add(new Item("CHN1", "Naughty Shin Chen Veg Platter", getString(R.string.chinese1), 0, 440, 0, defaultCust));
        menu18.add(new Item("CHN2", "Ninja Non Veg Platter", getString(R.string.chinese2), 0, 550, 0, defaultCust));
        menu18.add(new Item("CHN3", "Pikachu's Small Chinese Platter", getString(R.string.chinese3), 2, 350, 1, menu18custItem3));
    }

    public void loadMenu19() {
        ArrayList<Customizables> defaultCust = new ArrayList<>();
        ArrayList<Customizables> menu19custItem3 = new ArrayList<>();
        menu19custItem3.add(veg);
        menu19custItem3.add(nonveg9);
        menu19.add(new Item("ARB1", "Genie Bell Herby Veg Platter", getString(R.string.arabic1), 0, 420, 0, defaultCust));
        menu19.add(new Item("ARB2", "Aladin Low Cal Non Veg Platter", getString(R.string.arabic2), 1, 520, 0, defaultCust));
        menu19.add(new Item("ARB3", "Boss Baby Platter", getString(R.string.arabic3), 2, 320, 1, menu19custItem3));
    }

    public void loadMenu20() {
        ArrayList<Customizables> defaultCust = new ArrayList<>();
        menu20.add(new Item("DSRT1", "Peter Pan Baked Cheese Cake", getString(R.string.dessert1), 3, 190, 0, defaultCust));
        menu20.add(new Item("DSRT2", "Stripes Zebra Cheese Cake", getString(R.string.dessert2), 3, 210, 0, defaultCust));
        menu20.add(new Item("DSRT3", "Flintstones Mango Cheese Cake", getString(R.string.dessert3), 3, 170, 0, defaultCust));
        menu20.add(new Item("DSRT4", "X-Men Blue Berry Cheese Cake", getString(R.string.dessert4), 3, 170, 0, defaultCust));
        menu20.add(new Item("DSRT5", "Black Panther Choco Fudge Brownies", getString(R.string.dessert5), 0, 240, 0, defaultCust));
        menu20.add(new Item("DSRT6", "Snoopy Safron Baked Yogurt", getString(R.string.dessert6), 0, 200, 0, defaultCust));
        menu20.add(new Item("DSRT7", "Chocolate Lava Cake with Ice Cream", getString(R.string.dessert7), 0, 235, 0, defaultCust));
        menu20.add(new Item("DSRT8", "Shanghai Special Apple Toffee", getString(R.string.dessert8), 0, 210, 0, defaultCust));
        menu20.add(new Item("DSRT9", "Gulab Jamun Rosy Parfait", getString(R.string.dessert9), 0, 190, 0, defaultCust));
        menu20.add(new Item("DSRT10", "Banoffie Pie", getString(R.string.dessert10), 3, 170, 0, defaultCust));
        menu20.add(new Item("DSRT11", "Strawberry Cheese Cake", getString(R.string.dessert11), 3, 170, 0, defaultCust));
        menu20.add(new Item("DSRT12", "Baked New York Cheese Cake", getString(R.string.dessert12), 3, 160, 0, defaultCust));
        menu20.add(new Item("DSRT13", "Flavoured Kulfi", getString(R.string.dessert13), 0, 140, 0, defaultCust));
        menu20.add(new Item("DSRT14", "Lemon Grass Souffle", getString(R.string.dessert14), 0, 120, 0, defaultCust));
        menu20.add(new Item("DSRT15", "Phirni Tart", getString(R.string.dessert15), 0, 120, 0, defaultCust));
        menu20.add(new Item("DSRT16", "Tiramisu Cheese Cake", getString(R.string.dessert16), 3, 161.90, 0, defaultCust));
        menu20.add(new Item("DSRT17", "Nutella Cheese Cake", getString(R.string.dessert17), 3, 142.90, 0, defaultCust));


    }
//    public void addToCart(){
//        Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show();
//    }


    public void loadCustoms() {
        veg = new Customizables("Veg", 0, 0);
        veg1 = new Customizables("Veg", 20, 0);
        grilledVeg = new Customizables("Grilled Veg", 0, 0);

        nonveg = new Customizables("Non Veg", 30, 1);
        nonveg1 = new Customizables("Non Veg", 35, 1);
        nonveg2 = new Customizables("Non Veg", 50, 1);
        nonveg3 = new Customizables("Non Veg", 40, 1);
        nonveg4 = new Customizables("Non Veg", 60, 1);
        nonveg5 = new Customizables("Non Veg", 70, 1);
        nonveg6 = new Customizables("Non Veg", 80, 1);
        nonveg7 = new Customizables("Non Veg", 90, 1);
        nonveg8 = new Customizables("Non Veg", 100, 1);
        nonveg9 = new Customizables("Non Veg", 110, 1);

        chk = new Customizables("Chicken", 35, 1);
        chk1 = new Customizables("Chicken", 30, 1);
        chk2 = new Customizables("Chicken", 75, 1);
        chk3 = new Customizables("Chicken", 70, 1);
        chk4 = new Customizables("Chicken", 80, 1);
        chk5 = new Customizables("Chicken", 90, 1);

        mutton = new Customizables("Mutton", 0, 1);

        prawn = new Customizables("Prawns", 135, 1);
        prawn1 = new Customizables("Prawns", 85, 1);
        prawn2 = new Customizables("Prawns", 70, 1);
        prawn3 = new Customizables("Prawns", 60, 1);

        lamb = new Customizables("Lamb", 85, 1);

        seafood = new Customizables("Sea Food", 130, 1);
        seafood1 = new Customizables("Sea Food", 110, 1);

        vanilla = new Customizables("Vanilla", 0, 0);
        strawberry = new Customizables("Strawberry", 0, 0);
        chocolate = new Customizables("Chocolate", 0, 0);
        coffee = new Customizables("Coffee", 10, 0);
        butterscotch = new Customizables("Butter Scotch", 0, 0);
        belgianChocolate = new Customizables("Belgian Chocolate", 25, 0);
        mocha = new Customizables("Mocha", 0, 0);
        plate1 = new Customizables("Plate 1", 0, 0);
        plate2 = new Customizables("Plate 2", 20, 0);
        plate3 = new Customizables("Plate 3", 70, 0);
        classic = new Customizables("Classic", 0, 0);
        multigrain = new Customizables("Multi Grain", 0, 0);
        grilledChicken = new Customizables("Grilled Chicken", 0, 1);
        chikensalad = new Customizables("Chicken Salad", 40, 1);
        cheeseandham = new Customizables("Cheese and Ham", 70, 1);
        crispy = new Customizables("Crispy", 0, 0);
        fluffy = new Customizables("Fluffy", 0, 0);
        plain = new Customizables("Plain", 0, 0);
        egg = new Customizables("Egg", 20, 1);
        mushroom = new Customizables("Mushroom", 0, 0);
        mongolianstyle = new Customizables("Mongolian Style", 0, 0);
        shanghaistyle = new Customizables("Shanghai Style", 100, 0);
        cheese = new Customizables("Cheese", 20, 0);
    }

}
