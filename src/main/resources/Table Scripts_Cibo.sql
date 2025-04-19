drop database if exists cibo;
create database cibo;
use cibo;

create table users (
	user_id int auto_increment,
	user_name varchar(20) not null,
	email_id varchar(30) not null,
	contact_number varchar(10) not null,
	password varchar(70) not null,  
	constraint cibo_users_pk primary key (user_id)
);

create table roles (
	role_id int auto_increment,
	role_type varchar(10) not null,
	user_id int,
	constraint cibo_roles_pk primary key (role_id)
);

create table restaurant (
	restaurant_id int auto_increment,
	user_id int,
	restaurant_name varchar(20) not null,
	restaurant_contact varchar(30) not null,
	restaurant_type varchar(10) not null,
	address_line1 varchar(20) not null,
	area varchar(15) not null,
	city varchar(15) not null,
	res_state varchar(17) not null,
	pincode int not null,
	approval_status varchar(10) not null,
	avg_rating double,
	photo_urls varchar(200) not null,
	constraint cibo_restaurant_pk primary key (restaurant_id)
);

create table restaurant_transaction (
	restaurant_transaction_id int auto_increment,
	restaurant_id int,
	restaurant_order_counter int not null,
	restaurant_approx_cost int not null,
	restaurant_status boolean default false,
	constraint cibo_restaurant_t_pk primary key (restaurant_transaction_id)
);

create table coupon (
	coupon_id int auto_increment,
	coupon_code varchar(10) not null,
	minimum_bill int not null,
	maximum_redemption int not null,
	start_date datetime default current_timestamp,
	end_date datetime default current_timestamp,
	constraint cibo_coupon_pk primary key (coupon_id)
);

create table user_address (
	user_address_id int auto_increment,
	user_id int,
	user_address_name varchar(10) not null,
	address_line1 varchar(30) not null,
	address_line2 varchar(30) not null,
	area varchar(20) not null,
	city varchar(17) not null,
	user_state varchar(20) not null,
	pincode int not null,
	constraint cibo_user_address_pk primary key (user_address_id)
);

create table orders (
	order_id int auto_increment,
	user_id int,
	order_bill int not null,
	order_status varchar(30) not null,
	constraint cibo_order_pk primary key (order_id)
);

create table order_items (
	order_items_id int auto_increment,
	dish_id int,
	order_id int,
	qty int not null,
	constraint cibo_order_items_pk primary key (order_items_id)	
);

create table dish (
	dish_id int auto_increment,
	restaurant_id int,
	dish_name varchar(30) not null,
	dish_cuisine varchar(20) not null,
	dish_type varchar(10) not null,
	dish_description varchar(150) not null,
	speciality varchar(30) not null,
	price double not null,
	avg_rating double not null,
	image_url varchar(50) not null,
	constraint cibo_dish_pk primary key (dish_id)
);

create table dish_rating (
	dish_rating_id int auto_increment,
	dish_id int,
	user_id int not null,
	rating int default 0,
	constraint cibo_dish_rating_fk primary key (dish_rating_id)
);

create table wallet (
	wallet_id int auto_increment,
	user_id int not null,
	available_amount int(10) not null,
	constraint cibo_wallet_pk primary key (wallet_id)
);

create table user_likes (
	like_id int auto_increment,
	veg_nonveg varchar(10) not null,
	dish_id int,
	user_id int not null,
	restaurant_id int not null,
	constraint cibo_user_likes_pk primary key (like_id)
);

create table table_booking (
	booking_id int auto_increment,
	booking_date date not null,
	no_of_people int not null,
	time_of_booking datetime default current_timestamp,
	restaurant_id int not null,
	user_id int not null,
	constraint cibo_bookings_pk primary key (booking_id)
);
-- INSERT CODE TO USERS TABLE
INSERT INTO users VALUES (101, 'SCOTT', 'scott@stark.com', '8884967823', '3284cbd43ac6fc733d7c3d2176e7a52bbaeba81471702ec332a0a65689cf16e3');
-- Scott@123
INSERT INTO users VALUES (102, 'TONY', 'tony@stark.com', '8875632142', '1f7cbaa9168ffce48872d8fc4e5429dee55ed8f21d8d84bccd6aaa2a72ae1d79');
-- Tony@123
INSERT INTO users VALUES (103, 'STEVE', 'steve@gmail.com', '9880253413', '97661249431ccedba1711b78fb58eceb2c03054a07a7b684ad53048691b34435');
-- Steve@123
INSERT INTO users VALUES (104, 'ISABELLE', 'banner@Uv.com', '8882039476', '9a8d7e96acac7b73f1f9c994dd512df9068bb0549961e42333745c67a994e6f1');
-- Banner@123
INSERT INTO users VALUES (105, 'ROSE', 'rose@Uv.com', '9476888203', '9a8d7e96acac7b73f1f9c994dd512df9068bb0549961e42333745c67a994e6f1');
-- Banner@123

-- INSERT CODE TO ROLES TABLE
INSERT INTO roles VALUES (1,'CUSTOMER',104);
INSERT INTO roles VALUES (2,'VENDOR',102);
INSERT INTO roles VALUES (3,'CUSTOMER',101);
INSERT INTO roles VALUES (4,'VENDOR',104);
INSERT INTO roles VALUES (5,'CUSTOMER',103);
INSERT INTO roles VALUES (6,'ADMIN',105);

INSERT INTO restaurant VALUES (1,102,'KFC','9823414141','Nonveg','23, Shastri Nagar','Baner','Pune','Maharashtra',411041,'Accepted',4.2,'assets/kfca1.jpg-assets/kfca2.jpg-assets/kfca3.jpg');
INSERT INTO restaurant VALUES (2,102,'KFC','8934217843','Nonveg','3, Gajanan Nagar','Kothrud','Pune','Maharashtra',411038,'Accepted',4.2,'assets/kfcb1.jpg-assets/kfcb2.jpg-assets/kfcb3.jpg');
INSERT INTO restaurant VALUES (3,104,'Pizza Hut','8784393421','Veg','21, Adalat road','Rajouri Garden','Delhi','Delhi',110027,'Accepted',4.5,'assets/pizzahut1.jpg-assets/pizzahut2.jpg-assets/pizzahut3.jpg');
INSERT INTO restaurant VALUES (4,104,'Master Kitchen','8777772771','Nonveg','52, Sandesh road','Vasant Vihar','Delhi','Delhi',110057,'Accepted',4.1,'assets/masterkitchen1.jpg-assets/masterkitchen2.jpg-assets/masterkitchen3.jpg');
INSERT INTO restaurant VALUES (5,104,'Diamond Cafe','8977772771','Veg','11, Bandana circle','Vasant Vihar','Delhi','Delhi',110057,'Accepted',4.3,'assets/cafe1.jpg-assets/cafe2.jpg-assets/cafe3.jpg');
INSERT INTO restaurant VALUES (6,104,'Empire restaurant','9877226354','Veg','2, Amol Complex','Vasant Vihar','Delhi','Delhi',110057,'Accepted',4.3,'assets/empire1.jpg-assets/empire2.jpg');
INSERT INTO restaurant VALUES (7,102,'Bake N Shake','8823414141','Nonveg','33 Mayura Circle','Baner','Pune','Maharashtra',411041,'Accepted',4.2,'assets/bns.jpg');
INSERT INTO restaurant VALUES (8,102,'Ten Downing Street','7823414141','Nonveg','3 Madge Circle','Kothrud','Pune','Maharashtra',411038,'Accepted',3.6,'assets/tds.jpg');
INSERT INTO restaurant VALUES (9,104,'Urban Socialite','8989898976','Veg','21 Upper Lake','Shyamla Hills','Bhopal','Madhya Pradesh',462039,'Accepted',4.3,'assets/mys3.jpg');
INSERT INTO restaurant VALUES (10,102,'Over The Moon','8765678987','Egg','3 Ishwar Nagar','Hebbal','Mysore','Karnataka',570023,'Accepted',3.8,'assets/mys2.jpg');
INSERT INTO restaurant VALUES (11,102,'The Public House','7654567876','Veg','51 Abhishek Circle','Hootagalli','Mysore','Karnataka',570027,'Accepted',4.0,'assets/mys1.jpg');

INSERT INTO restaurant_transaction VALUES (1,1,2,500,true);
INSERT INTO restaurant_transaction VALUES (2,2,1,500,false);
INSERT INTO restaurant_transaction VALUES (3,3,2,350,true);
INSERT INTO restaurant_transaction VALUES (4,4,1,500,false);
INSERT INTO restaurant_transaction VALUES (5,5,2,350,true);
INSERT INTO restaurant_transaction VALUES (6,6,0,400,true);
INSERT INTO restaurant_transaction VALUES (7,1,2,500,true);
INSERT INTO restaurant_transaction VALUES (8,2,1,500,false);
INSERT INTO restaurant_transaction VALUES (9,3,2,350,true);
INSERT INTO restaurant_transaction VALUES (10,4,1,500,false);
INSERT INTO restaurant_transaction VALUES (11,5,2,350,true);

INSERT INTO coupon VALUES (1001,'CIBO20',200,100,sysdate()- interval 12 day,sysdate()- interval 5  day);
INSERT INTO coupon VALUES (1002,'FOOD30',300,125,sysdate()- interval 15 day,sysdate()- interval 3  day);
INSERT INTO coupon VALUES (1003,'HUNGRY25',250,100,sysdate()- interval 10 day,sysdate()- interval 2  day);


-- INSERT CODE TO user_address TABLE
INSERT INTO user_address VALUES (1,101,'Home','407, Rajhans Apartments','Lashkar Mohalla','Vasant Vihar','Delhi','Delhi',110029);
INSERT INTO user_address VALUES (2,101,'Work','Bajaj Industrial Area','Navneeth nagar','Vasant Vihar','Delhi','Delhi',110029);
INSERT INTO user_address VALUES (3,103,'Home','A2/1, Indira Soceity','Lalvani nagar','Baner','Pune','Maharashtra',411037);
INSERT INTO user_address VALUES (4,103,'Work','A705, AjayDeep Complex','Lalvani nagar','Kothrud','Pune','Maharashtra',411037);
INSERT INTO user_address VALUES (5,105,'Home','309, Leo Janani Apartments','Lakshmikanth nagar','Rajouri Garden','Delhi','Delhi',110027);
INSERT INTO user_address VALUES (6,104,'Home','304, Rajhans Apartments','Lashkar Mohalla','Vasant Vihar','Delhi','Delhi',110029);

-- INSERT CODE TO orders TABLE
INSERT INTO orders VALUES (1001,101,300,'INACTIVE');
INSERT INTO orders VALUES (1002,105,750,'ACTIVE');
INSERT INTO orders VALUES (1003,103,800,'ACTIVE');
INSERT INTO orders VALUES (1004,103,550,'INACTIVE');
INSERT INTO orders VALUES (1005,105,700,'INACTIVE');

-- INSERT CODE TO dish TABLE
INSERT INTO dish VALUES (1001,1,'Chicken Burger','Burger','Nonveg','Spicy and chrunchy chicken tikki in soft bun with fresh lettuce and mustard sauce','Chef Special',150.0,4.5,'assets/chicken_burger.jpg');
INSERT INTO dish VALUES (1002,1,'Chicken Cheese Burger','Burger','Nonveg','Spicy and chrunchy chicken tikki with soft bun with fresh lettuce and extra cheese','Chef Special',200.0,4.2,'assets/chicken_cheese_burger.jpg');
INSERT INTO dish VALUES (1003,1,'Chicken Wings','chicken','Nonveg','Spicy and chrunchy chicken wings','Chef Special',550.0,4.6,'assets/chicken_wings.jpg');
INSERT INTO dish VALUES (1004,3,'Margarita Pizza','Pizza','Veg','Plain and classic cheese pizza','Chef Special',250.0,4.4,'assets/margarita_pizza.jpg');
INSERT INTO dish VALUES (1005,3,'Peppy Paneer Pizza','Pizza','Veg','Pizza topped with fresh cottage cheese, capsicum and red paprika','Chef Special',350.0,4.3,'assets/paneer_pizza.jpg');
INSERT INTO dish VALUES (1006,2,'Chicken Burger','Burger','Nonveg','Spicy and chrunchy chicken tikki with soft bun with fresh lettuce and mustard sauce','Chef Special',150.0,4.5,'assets/chicken_burger.jpg');
INSERT INTO dish VALUES (1007,2,'Chicken Cheese Burger','Burger','Nonveg','Spicy and chrunchy chicken tikki with soft bun with fresh lettuce and extra cheese','Chef Special',200.0,4.2,'assets/chicken_cheese_burger.jpg');
INSERT INTO dish VALUES (1008,2,'Chicken Wings','chicken','Nonveg','Spicy and chrunchy chicken wings','Chef Special',550.0,4.6,'assets/chicken_wings.jpg');
INSERT INTO dish VALUES (1009,3,'Farmhouse Pizza','Pizza','Veg','Pizza topped with fresh green olives, tomatoes and onions','Chef Special',400.0,3.8,'assets/farmhouse_pizza.jpg');
INSERT INTO dish VALUES (1010,3,'Exotica Pizza','Pizza','Veg','Pizza topped with fresh cottage cheese, onions, capsicum, tomatoes and corn','Chef Special',410.0,4.3,'assets/exotica_pizza.jpg');
INSERT INTO dish VALUES (1011,3,'Veg Loaded Pizza','Pizza','Veg','Pizza topped with fresh corn, black olives, zuchini, capsicum, yellow and red bell peppers','Chef Special',450.0,4.5,'assets/veg_loaded_pizza.jpg');
INSERT INTO dish VALUES (1012,1,'French Fries','Fries','Veg','Classic crunchy and tasty french fries','Chef Special',200.0,4.5,'assets/french_fries.jpg');
INSERT INTO dish VALUES (1013,2,'French Fries','Fries','Veg','Classic crunchy and tasty french fries','Chef Special',200.0,4.5,'assets/french_fries.jpg');
INSERT INTO dish VALUES (1014,6,'Veg Biryani','Biryani','Veg','Flavoured rice with marinated vegetables garnished with fried onions and cashews','Chef Special',450.0,4.5,'assets/veg_biryani.jpg');
INSERT INTO dish VALUES (1015,6,'Paneer Chilly','Starter','Veg','Fresh cottage cheese tossed in tasty hot and sweet sauce','Chef Special',350.0,4.5,'assets/paneer_chilly.jpg');
INSERT INTO dish VALUES (1016,6,'Caesar Salad','Salad','Veg','Romaine lettuce and croutons dressed with lemon juice, worcestershire sauce, olive oil and parmesan cheese','Chef Special',550.0,4.5,'assets/caesar_salad.jpg');

INSERT INTO dish VALUES (1018,4,'Chicken Biryani','North Indian','Nonveg','Delicious savory rice dish loaded with spicy marinated chicken and caramelized onions','Chef Special',300.0,4.5,'assets/chicken_biryani.jpg');
INSERT INTO dish VALUES (1019,4,'Butter Chicken','North Indian','Nonveg','Marinated chicken roasted and cooked in tomato puree, cream, butter and a host of masalas','Chef Special',250.0,4.2,'assets/chicken_lababdar.jpg');
INSERT INTO dish VALUES (1020,4,'Lemon Chicken','North Indian','Nonveg','Pan seared chicken breasts are coated with a tangy and rich lemon butter sauce','Chef Special',250.0,4.3,'assets/lemon_chicken.jpg');
INSERT INTO dish VALUES (1021,4,'Fish Curry','North Indian','Nonveg','Exclusive taste of roasted spices seeped into juicy fish pieces','Chef Special',235.0,4.2,'assets/fish_curry.jpg');
INSERT INTO dish VALUES (1022,4,'Fish Platter','North Indian','Nonveg','Smoked Fish Platter with honey-mustard dill sauce and cucumber-coriander yogurt','Chef Special',270.0,4.3,'assets/fish_platter.jpg');
INSERT INTO dish VALUES (1023,8,'Grilled Fish','North Indian','Nonveg','Delicious, crispy and fried fish served with flavoured sauce','Chef Special',200.0,3.8,'assets/grilled_fish.jpg');
INSERT INTO dish VALUES (1024,8,'Fried Chicken','North Indian','Nonveg','Chicken marinated in beautiful gravy and deep fried','Chef Special',250.0,4.6,'assets/fried_chicken.jpg');
INSERT INTO dish VALUES (1025,8,'Chicken Platter','North Indian','Nonveg','Smoked Fish Platter with honey-mustard dill sauce and cucumber-coriander yogurt','Chef Special',250.0,4.4,'assets/chicken_platter.jpg');
INSERT INTO dish VALUES (1026,8,'Fish N Chips','Starter','Nonveg','Fried marinated fish served with fries and veggies','Chef Special',230.0,4.2,'assets/fish_n_chips.jpg');
INSERT INTO dish VALUES (1027,4,'Chicken Salad','Salad','Nonveg','Seasoned chicken breast, creamy mayonnaise, lemon juice, crunchy celery, and almonds','Chef Special',200.0,4.3,'assets/chicken_salad.jpg');


INSERT INTO dish VALUES (1029,5,'Dal Makhani','North Indian','Veg','Classic Indian dish made with whole urad dal, rajma, butter and spices','Chef Special',150.0,4.6,'assets/dal_makhani.jpg');
INSERT INTO dish VALUES (1030,5,'Gobi Masala','North Indian','Veg','Cauliflower fried and sauted in spicy masala gravy','Chef Special',150.0,3.8,'assets/gobhi_masala.jpg');
INSERT INTO dish VALUES (1031,5,'Paneer Mushroom','North Indian','Veg','Classic Indian gravy prepared with mushroom, peas and paneer','Chef Special',200.0,3.7,'assets/paneer_mushroom.jpg');
INSERT INTO dish VALUES (1032,5,'Mix Veg','North Indian','Veg','Mixture of vegetables together in a traditional Indian onion-tomato gravy','Chef Special',150.0,4.6,'assets/mix_veg.jpg');
INSERT INTO dish VALUES (1033,5,'Dal Fry','North Indian','Veg','Spicy punjabi dish made from mixed dals like toor, chana, moong, masoor dal','Chef Special',160.0,4.4,'assets/dal_fry.jpg');
INSERT INTO dish VALUES (1034,5,'Butter Paneer','North Indian','Veg','Rich and creamy dish of paneer in a tomato, butter and cashew sauce','Chef Special',200.0,4.2,'assets/butter_paneer.jpg');
INSERT INTO dish VALUES (1035,5,'Veg Kofhta','North Indian','Veg','Exotic Indian gravy dish made from mix vegetable dumplings dunked in a onion-tomato based gravy','Chef Special',200.0,3.8,'assets/kofhta.jpg');
INSERT INTO dish VALUES (1036,5,'Kadai Paneer','North Indian','Veg','Indian cottage cheese and bell peppers cooked in a spicy masala','Chef Special',200.0,4.3,'assets/kadai_paneer.jpg');
INSERT INTO dish VALUES (1037,9,'Kadai Veg','North Indian','Veg','A mixture of veggies in cooked in a spicy gravy flavored with a special kadai masala','Chef Special',230.0,4.8,'assets/veg_tadka.jpg');
INSERT INTO dish VALUES (1038,9,'Chole Masala','North Indian','Veg','Delicious & flavorful curry made by cooking chickpeas in a spicy onion tomato masala gravy','Chef Special',250.0,3.6,'assets/chole_masala.jpg');
INSERT INTO dish VALUES (1039,9,'Navratna Curry','North Indian','Veg','Nine gems and korma is a creamy nutty curry','Chef Special',250.0,4.3,'assets/navratna_curry.jpg');
INSERT INTO dish VALUES (1040,9,'Rajma Rice','North Indian','Veg','Delicious & flavorful curry made with red kidney beans aka rajma','Chef Special',250.0,4.6,'assets/rajma_chawal.jpg');
INSERT INTO dish VALUES (1041,9,'Paneer Tikka','North Indian','Veg','Indian dish of marinated paneer cheese served in a spiced gravy','Chef Special',200.0,4.1,'assets/tikka.jpg');
INSERT INTO dish VALUES (1042,9,'Veg Korma','North Indian','Veg','Boiled vegetables cooked in creamy and aromatic gravy of yogurt, coconut and cashew nuts','Chef Special',200.0,4.0,'assets/korma.jpg');
INSERT INTO dish VALUES (1028,5,'Palak Paneer','North Indian','Veg','Indian cottage cheese cooked with spinach and spices in creamy and flavorful curry','Chef Special',200.0,4.3,'assets/palak_paneer.jpg');
INSERT INTO dish VALUES (1017,11,'Tandoori Paneer','Tandoor','Veg','Fresh cottage cheese marinated in spices and cooked in the tandoor','Chef Special',450.0,4.5,'assets/ptm.jpg');

INSERT INTO dish VALUES (1043,7,'Maple Butter Waffle','Bakery','Egg','Classic crispy waffle with warm melted butter and maple syrup drizzle','Chef Special',170.0,4.3,'assets/maple_waffle.jpg');
INSERT INTO dish VALUES (1044,7,'Triple Chocolate Waffle','Bakery','Egg','Classic crispy waffle with warm melted white and dark chocolate','Chef Special',200.0,4.5,'assets/choco_waffle.jpg');
INSERT INTO dish VALUES (1045,7,'Apple Tart','Bakery','Egg','Soft, yet crisp base with a sweet taste and a slightly tart finish tuopped with apple','Chef Special',150.0,4.8,'assets/apple_tart.jpg');
INSERT INTO dish VALUES (1046,7,'Chocolate Mousse','Bakery','Egg','Decadently creamy, light and billowy, and indulgently chocolaty','Chef Special',150.0,4.2,'assets/choco_mousse.jpg');
INSERT INTO dish VALUES (1047,7,'Death By Chocolate','Bakery','Egg','Rich layered chocolaty dessert','Chef Special',250.0,4.3,'assets/dbc.jpg');

INSERT INTO dish VALUES (1048,10,'Schezwan Noodle','Chinese','Veg','Classic noodle prepared in spicy schezwan sauce','Chef Special',230.0,4.2,'assets/schz_noodles.jpg');
INSERT INTO dish VALUES (1049,10,'Hakka Noodle','Chinese','Veg','Classic noodle prepared in variety of sauce','Chef Special',270.0,4.0,'assets/hakka_noodle.jpg');
INSERT INTO dish VALUES (1054,11,'Veg Lasagna','Italian','Veg','Sauted cheesy veggies arraged in between layers of lasagne sheets','Chef Special',200.0,4.5,'assets/lsg.jpg');
INSERT INTO dish VALUES (1050,10,'Momos','Chinese','Veg','Soft dumplings filled with sauted veggies, served with spicy sauce','Chef Special',100.0,3.3,'assets/momo.jpg');
INSERT INTO dish VALUES (1053,10,'Munchurian','Chinese','Veg','Soft vegetable balls served in rich spicy machurian gravy','Chef Special',150.0,4.3,'assets/munchurian.jpg');

INSERT INTO dish VALUES (1051,11,'Pasta Alfredo','Italian','Veg','Soft boiled pasta tossed in cheesy creamy white sauce, olives and veggies','Chef Special',250.0,4.5,'assets/alf_pasta.jpg');
INSERT INTO dish VALUES (1052,11,'Garlic Bread','Bakery','Veg','Cheesy stuffed garlic bread shallow grilled','Chef Special',150.0,4.3,'assets/gb.jpg');


-- INSERT CODE TO order_items TABLE
INSERT INTO order_items VALUES (1,1001,1001,2);
INSERT INTO order_items VALUES (2,1004,1002,3);
INSERT INTO order_items VALUES (3,1002,1003,4);
INSERT INTO order_items VALUES (4,1003,1004,1);
INSERT INTO order_items VALUES (5,1005,1005,2);

-- INSERT CODE TO dish_rating TABLE
INSERT INTO dish_rating VALUES (1,1002,101,4);
INSERT INTO dish_rating VALUES (2,1001,101,4);
INSERT INTO dish_rating VALUES (3,1002,102,4);
INSERT INTO dish_rating VALUES (4,1002,103,4);
INSERT INTO dish_rating VALUES (5,1003,101,4);
INSERT INTO dish_rating VALUES (6,1004,101,4);

-- INSERT CODE TO wallet TABLE
INSERT INTO wallet VALUES (1,101,700);
INSERT INTO wallet VALUES (2,102,700);
INSERT INTO wallet VALUES (3,103,700);
INSERT INTO wallet VALUES (4,104,700);

-- INSERT CODE TO user_likes TABLE
INSERT INTO user_likes VALUES (1,'Nonveg',1001,101,1);
INSERT INTO user_likes VALUES (2,'Nonveg',1002,103,2);
INSERT INTO user_likes VALUES (3,'Veg',1004,101,3);
INSERT INTO user_likes VALUES (4,'Veg',1005,105,3);

-- INSERT CODE TO table_booking TABLE
INSERT INTO table_booking VALUES (1,sysdate(),4,current_time(),1,101);
INSERT INTO table_booking VALUES (2,sysdate(),2,current_time(),2,103);
INSERT INTO table_booking VALUES (3,sysdate(),4,current_time(),3,105);