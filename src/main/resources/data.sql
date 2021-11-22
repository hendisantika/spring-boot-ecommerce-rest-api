-- Users
-- Normal User: username: user, password: user, role: USER
INSERT INTO app_user (id, username, password, role)
VALUES (1, 'user1', '$2a$10$UcSltcvIoORWLKcCxo.4quqBWSoD0ZdC86caU..NSzNJdOdqgrKx2', 'USER');
INSERT INTO app_user (id, username, password, role)
VALUES (2, 'user2', '$2a$10$egfNXcVS6VnfxpoJrqNIJO2za/OyfQbPU81YgqH8eqdKFN6F8fcs6', 'USER');
-- Admin / Super User: username: admin, password: admin, role: ADMIN
INSERT INTO app_user (id, username, password, role)
VALUES (3, 'admin', '$2a$10$1e2I81sXJW0gJDKyDZxhc.JXXIpK1Y0T4AKp0GwNs32370Wa2bDqK', 'ADMIN');
-- Categories
INSERT INTO app_category (id, name, parentid)
VALUES (1, 'Electronics', NULL);
INSERT INTO app_category (id, name, parentid)
VALUES (2, 'Clothing, Shoes & Accessories', NULL);
INSERT INTO app_category (id, name, parentid)
VALUES (3, 'Home & Outdoor', NULL);
INSERT INTO app_category (id, name, parentid)
VALUES (4, 'Beauty & Personal Care', NULL);
INSERT INTO app_category (id, name, parentid)
VALUES (5, 'Everything Else', NULL);
-- Subcategories for 'Electronics'
INSERT INTO app_category (id, name, parentid)
VALUES (6, 'Audio & Video Components', 1);
INSERT INTO app_category (id, name, parentid)
VALUES (7, 'Camera & Photo', 1);
INSERT INTO app_category (id, name, parentid)
VALUES (8, 'Computers', 1);
-- Subcategories for 'Clothing, Shoes & Accessories'
INSERT INTO app_category (id, name, parentid)
VALUES (9, 'Clothing', 2);
INSERT INTO app_category (id, name, parentid)
VALUES (10, 'Costumes & Accessories', 2);
INSERT INTO app_category (id, name, parentid)
VALUES (11, 'Fashion Accessories', 2);
-- Subcategories for 'Home & Outdoor'
INSERT INTO app_category (id, name, parentid)
VALUES (12, 'Furniture, Decor & Storage', 3);
INSERT INTO app_category (id, name, parentid)
VALUES (13, 'Antiques', 3);
INSERT INTO app_category (id, name, parentid)
VALUES (14, 'Appliances', 3);
-- Subcategories for 'Beauty & Personal Care'
INSERT INTO app_category (id, name, parentid)
VALUES (15, 'Accessories', 4);
INSERT INTO app_category (id, name, parentid)
VALUES (16, 'Bath & Shower', 4);
INSERT INTO app_category (id, name, parentid)
VALUES (17, 'Feminine Hygiene', 4);

-- Products for Category 'Electronics > Audio & Video Components'
INSERT INTO app_product (id, name, price, userid)
VALUES (1, 'TV 4K (32 GB)', 223.22, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (2, 'RCA ANT751 OUTDOOR ANTENNA OPTIMIZED FOR DIGITAL RECEPTION - UPTO 3.3 FT', 49.22, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (3, 'APC REPLACEMENT BATTERY NO 24', 299.00, 2);
INSERT INTO app_product_category (productid, categoryid)
VALUES (1, 6);
INSERT INTO app_product_category (productid, categoryid)
VALUES (2, 6);
INSERT INTO app_product_category (productid, categoryid)
VALUES (3, 6);
-- Products for Category 'Electronics > Camera & Photo'
INSERT INTO app_product (id, name, price, userid)
VALUES (4, 'CAXXX EOS REBEL T6 DSLR 18-55MM - 1159C003', 379.95, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (5, 'RCA ANT751 OUTDOOR ANTENNA OPTIMIZED FOR DIGITAL RECEPTION - UPTO 3.3 FT', 49.22, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (6,
        'BEST CHOICE PRODUCTS 6-AXIS HEADLESS RC QUADCOPTER FPV RC DRONE W/ WIFI HD CAMERA, REAL TIME VIDEO, ALTITUDE HOLD',
        42.99, 2);
INSERT INTO app_product_category (productid, categoryid)
VALUES (4, 7);
INSERT INTO app_product_category (productid, categoryid)
VALUES (5, 7);
INSERT INTO app_product_category (productid, categoryid)
VALUES (6, 7);
-- Products for Category 'Electronics > Computers'
INSERT INTO app_product (id, name, price, userid)
VALUES (7,
        'APXXX MXCBXXK AIR MQD42LL/A 13.3" LCD NOTEBOOK - INTEL CORE I5 (5TH GEN) DUAL-CORE (2 CORE) 1.80 GHZ - 8 GB LPDDR3 - 256 GB SSD - MXC OS SIERRX - 1440 X 900 - INTXL HD GRAPHICS 6000 LPDDR3 - BLUETOOTH - ENGLISH (US) KEYBOARD - FRONT CAMERA/WEBCAM - IEEE 8',
        1052.49, 1);
INSERT INTO app_product (id, name, price, userid)
VALUES (8, 'DXLL INSPIXXN 13 5000 SERIES 2-IN-1- I3-7100U- 1TB HDD- 4GB RAM', 479.99, 1);
INSERT INTO app_product (id, name, price, userid)
VALUES (9, 'HEWLXXX PAXXXRD 11-AE010NR X360 11 INTXL N3350 CHROMEBOOK CONVERTIBLE LAPTOP - 2MW49UA#ABA', 239.00, 1);
INSERT INTO app_product_category (productid, categoryid)
VALUES (7, 8);
INSERT INTO app_product_category (productid, categoryid)
VALUES (8, 8);
INSERT INTO app_product_category (productid, categoryid)
VALUES (9, 8);
-- Products for Category 'Clothing, Shoes & Accessories > Clothing'
INSERT INTO app_product (id, name, price, userid)
VALUES (10, 'DICKXXX WP595DS 30 32 MENS REGULAR STRAIGHT STRETCH TWILL CARGO PANT - DESERT SAND - 30 - 32', 26.99, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (11, 'TINKXXXXLL - TINXXXXOTS GIRLS YOUTH SLEEP PANTS', 11.00, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (12, 'INTENSXXX N4700112LRG ADULT NYLON DOUBLE KNIT PANT&#44; WHITE & ROYAL - LARGE', 12.28, 2);
INSERT INTO app_product_category (productid, categoryid)
VALUES (10, 9);
INSERT INTO app_product_category (productid, categoryid)
VALUES (11, 9);
INSERT INTO app_product_category (productid, categoryid)
VALUES (12, 9);
-- Products for Category 'Clothing, Shoes & Accessories > Costumes & Accessories'
INSERT INTO app_product (id, name, price, userid)
VALUES (13, 'DISGUIXX SHADOW NINJA GREEN MASTER NINJA DELUXE BOYS COSTUME, ONE COLOR, 7-8', 24.15, 1);
INSERT INTO app_product (id, name, price, userid)
VALUES (14, 'ZAXXXX STUDIOS M6003 SUPER DELUXE ORANGUTAN MASK', 48.94, 1);
INSERT INTO app_product (id, name, price, userid)
VALUES (15, 'RUBXXX INFLATABLE CHEWBACCA ADULT COSTUME-STANDARD', 82.94, 1);
INSERT INTO app_product_category (productid, categoryid)
VALUES (13, 10);
INSERT INTO app_product_category (productid, categoryid)
VALUES (14, 10);
INSERT INTO app_product_category (productid, categoryid)
VALUES (15, 10);
-- Products for Category 'Clothing, Shoes & Accessories > Fashion Accessories'
INSERT INTO app_product (id, name, price, userid)
VALUES (16, 'RXX-XXN MENS GRADIENT ACTIVE RB3386-004/13-67 SILVER AVIATOR SUNGLASSES', 103.99, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (17, 'TENXXXY BASIC KNIT WIRELESS HANDS-FREE BLUETOOTH BEANIE WITH BUILT-IN SPEAKERS - GREY', 24.95, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (18, 'AIRBORXX EXXROIDERED BUCKET HAT W44S44E', 20.49, 2);
INSERT INTO app_product_category (productid, categoryid)
VALUES (16, 11);
INSERT INTO app_product_category (productid, categoryid)
VALUES (17, 11);
INSERT INTO app_product_category (productid, categoryid)
VALUES (18, 11);
-- Products for Category 'Home & Outdoor > Furniture, Decor & Storage'
INSERT INTO app_product (id, name, price, userid)
VALUES (19, 'BESXXXFICE HIGH BACK MODERN MESH OFFICE CHAIR - BLACK', 47.99, 1);
INSERT INTO app_product (id, name, price, userid)
VALUES (20, 'FOLXXXLE OUTDOOR WOOD ADIRONDACK CHAIR W/ PULL OUT OTTOMAN', 56.99, 1);
INSERT INTO app_product (id, name, price, userid)
VALUES (21, '13-GALXXN TXXCH-FREE SENSOR AUTOMATIC STAINLESS STEEL TRASH CAN - STAINLESS STEEL', 52.99, 1);
INSERT INTO app_product_category (productid, categoryid)
VALUES (19, 12);
INSERT INTO app_product_category (productid, categoryid)
VALUES (20, 12);
INSERT INTO app_product_category (productid, categoryid)
VALUES (21, 12);
-- Products for Category 'Home & Outdoor > Antiques'
INSERT INTO app_product (id, name, price, userid)
VALUES (22, 'COLXXXN SAN FRXXXISCO GIANTS 24 CAN SOFT SIDED COOLER/LUNCHBOX MLB', 29.99, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (23, 'AMERIXXWARE PSGAUS45 45 MM AUSTIN SNOW GLOBE', 10.11, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (24, '24 IN. W X 24 IN. H ROXXD XXBLE VENT LOXXER&#44; FUNCTIONAL', 73.24, 2);
INSERT INTO app_product_category (productid, categoryid)
VALUES (22, 13);
INSERT INTO app_product_category (productid, categoryid)
VALUES (23, 13);
INSERT INTO app_product_category (productid, categoryid)
VALUES (24, 13);
-- Products for Category 'Home & Outdoor > Appliances'
INSERT INTO app_product (id, name, price, userid)
VALUES (25, 'E-Z DISHXXXHER BRACKET AND SCREWS GRANITE COUNTERTOP INSTALLATION KIT', 9.99, 1);
INSERT INTO app_product (id, name, price, userid)
VALUES (26, 'BONAXXXA BV1500TS 5-CUP CAXAFE COFFEE BREWER, STAINLESS STEEL', 67.92, 1);
INSERT INTO app_product (id, name, price, userid)
VALUES (27, 'DUXXXP LCD 1800-WATT PORXXXLE INDUCTION COOKTOP COUNTERTOP BURNER 9600LS', 100.99, 1);
INSERT INTO app_product_category (productid, categoryid)
VALUES (25, 14);
INSERT INTO app_product_category (productid, categoryid)
VALUES (26, 14);
INSERT INTO app_product_category (productid, categoryid)
VALUES (27, 14);
-- Products for Category 'Beauty & Personal Care > Accessories'
INSERT INTO app_product (id, name, price, userid)
VALUES (28, 'SPACE-SAVING SHOE ORGANIZER: SET OF 12', 24.99, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (29, 'COLDSTXXL COLD STEEL TI-LITE ZYTEL 6" POLISHED KNIFE 7.5IN. X 1.5IN. X 1.25IN.', 57.79, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (30, 'LXZ CLXIBORNE BORX BORX MEN COLOGNE SPRAY 3.4 OZ', 19.98, 2);
INSERT INTO app_product_category (productid, categoryid)
VALUES (28, 15);
INSERT INTO app_product_category (productid, categoryid)
VALUES (29, 15);
INSERT INTO app_product_category (productid, categoryid)
VALUES (30, 15);
-- Products for Category 'Beauty & Personal Care > Bath & Shower'
INSERT INTO app_product (id, name, price, userid)
VALUES (31, 'MOLTXN BROWN SOOTHING MILK & OATMEAL SOAP 75G/2.6OZ SET OF 6', 37.99, 1);
INSERT INTO app_product (id, name, price, userid)
VALUES (32, 'BATH BRUSH BACK SCRXB SCRUBBER MASSAGER SHOWER BODY BACK 13.5 HANDLE SPA PET NEW', 7.49, 1);
INSERT INTO app_product (id, name, price, userid)
VALUES (33, '9X SOAP DISPENSER DISH CASE HOLDER CONTAINER BOX BATHROOM CLEAN DRY TRAVEL CARRY', 13.99, 1);
INSERT INTO app_product_category (productid, categoryid)
VALUES (31, 16);
INSERT INTO app_product_category (productid, categoryid)
VALUES (32, 16);
INSERT INTO app_product_category (productid, categoryid)
VALUES (33, 16);
-- Products for Category 'Beauty & Personal Care > Feminine Hygiene'
INSERT INTO app_product (id, name, price, userid)
VALUES (34, 'GENUINE JXE GJO14457 CITRUS SCXNTED LIQUID HANDWASH&#44; ORANGE', 11.63, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (35, 'GENUINE JXE GJO14467 ALCOHOL-FREE FOAM HAND SANITIZER&#44; CLEAR', 12.14, 2);
INSERT INTO app_product (id, name, price, userid)
VALUES (36, 'MENDX 35601 LASTING-TOUCH - BROWN ROUND 8 OZ - IMPRINTED ALCOHOL', 10.37, 2);
INSERT INTO app_product_category (productid, categoryid)
VALUES (34, 17);
INSERT INTO app_product_category (productid, categoryid)
VALUES (35, 17);
INSERT INTO app_product_category (productid, categoryid)
VALUES (36, 17);

-- Adding some Products to other categories
INSERT INTO app_product_category (productid, categoryid)
VALUES (1, 8);
INSERT INTO app_product_category (productid, categoryid)
VALUES (11, 10);
INSERT INTO app_product_category (productid, categoryid)
VALUES (23, 12);
INSERT INTO app_product_category (productid, categoryid)
VALUES (32, 17);
INSERT INTO app_product_category (productid, categoryid)
VALUES (34, 16);
INSERT INTO app_product_category (productid, categoryid)
VALUES (35, 16);
INSERT INTO app_product_category (productid, categoryid)
VALUES (36, 16);
