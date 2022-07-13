BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "restaurants" (
	"id"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"description"	TEXT NOT NULL,
	"district"	TEXT NOT NULL,
	"image"	TEXT NOT NULL,
	"qualification"	TEXT NOT NULL,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "foods" (
	"id"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"description"	TEXT NOT NULL,
	"price"	REAL NOT NULL,
	"image"	TEXT NOT NULL,
	"restaurant"	INTEGER NOT NULL,
	"restaurantName"	TEXT NOT NULL,
	"qualification"	TEXT NOT NULL,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "orders" (
	"id"	INTEGER,
	"date"	TEXT NOT NULL,
	"user"	TEXT NOT NULL,
	"status"	INTEGER NOT NULL,
	"total"	REAL NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "orders_detail" (
	"id"	INTEGER,
	"order_id"	INTEGER,
	"restaurant"	INTEGER NOT NULL,
	"food_id"	INTEGER NOT NULL,
	"quantity"	INTEGER NOT NULL,
	"total"	REAL NOT NULL,
	PRIMARY KEY("id")
);
INSERT INTO "restaurants" VALUES (1,'Dimas','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','Cercado','https://lh5.googleusercontent.com/p/AF1QipNbp0qDeXyA6Ye4-5oDB5Q6eIqLqywmTXXqbb22=w72-h72-n-k-no','5.0');
INSERT INTO "restaurants" VALUES (2,'Las Gringas','Restaurante discreto de pizzas novedosas estilo peruano, desayuno-almuerzo variados y cerveza tirada.','Cercado','https://lh5.googleusercontent.com/p/AF1QipPdDwZmzAUSF32yHP7dpEx_B3SV3HD1T3hK2Leu=w72-h72-n-k-no','4.0');
INSERT INTO "restaurants" VALUES (3,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (4,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (5,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (6,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (7,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (8,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (9,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (10,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (11,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (12,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (13,'Las Gringas','Restaurante discreto de pizzas novedosas estilo peruano, desayuno-almuerzo variados y cerveza tirada.','Cercado','https://lh5.googleusercontent.com/p/AF1QipPdDwZmzAUSF32yHP7dpEx_B3SV3HD1T3hK2Leu=w72-h72-n-k-no','4.0');
INSERT INTO "restaurants" VALUES (14,'Las Gringas','Restaurante discreto de pizzas novedosas estilo peruano, desayuno-almuerzo variados y cerveza tirada.','Cercado','https://lh5.googleusercontent.com/p/AF1QipPdDwZmzAUSF32yHP7dpEx_B3SV3HD1T3hK2Leu=w72-h72-n-k-no','4.0');
INSERT INTO "restaurants" VALUES (15,'Las Gringas','Restaurante discreto de pizzas novedosas estilo peruano, desayuno-almuerzo variados y cerveza tirada.','Cercado','https://lh5.googleusercontent.com/p/AF1QipPdDwZmzAUSF32yHP7dpEx_B3SV3HD1T3hK2Leu=w72-h72-n-k-no','4.0');
INSERT INTO "restaurants" VALUES (16,'Las Gringas','Restaurante discreto de pizzas novedosas estilo peruano, desayuno-almuerzo variados y cerveza tirada.','Cercado','https://lh5.googleusercontent.com/p/AF1QipPdDwZmzAUSF32yHP7dpEx_B3SV3HD1T3hK2Leu=w72-h72-n-k-no','4.0');
INSERT INTO "restaurants" VALUES (17,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (18,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (19,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (20,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (21,'Pasta Canteen','Opciones de servicio: Consumo en el lugar · Para llevar · Entrega sin contacto','C. Puente Grau 300','https://lh5.googleusercontent.com/p/AF1QipOEJy2CBfgoG3iCsRjy0_94ulZ0wdDGn_hfVLcp=w72-h72-n-k-no','3.0');
INSERT INTO "restaurants" VALUES (22,'Las Gringas','Restaurante discreto de pizzas novedosas estilo peruano, desayuno-almuerzo variados y cerveza tirada.','Cercado','https://lh5.googleusercontent.com/p/AF1QipPdDwZmzAUSF32yHP7dpEx_B3SV3HD1T3hK2Leu=w72-h72-n-k-no','4.0');
INSERT INTO "restaurants" VALUES (23,'Las Gringas','Restaurante discreto de pizzas novedosas estilo peruano, desayuno-almuerzo variados y cerveza tirada.','Cercado','https://lh5.googleusercontent.com/p/AF1QipPdDwZmzAUSF32yHP7dpEx_B3SV3HD1T3hK2Leu=w72-h72-n-k-no','4.0');
INSERT INTO "restaurants" VALUES (24,'Las Gringas','Restaurante discreto de pizzas novedosas estilo peruano, desayuno-almuerzo variados y cerveza tirada.','Cercado','https://lh5.googleusercontent.com/p/AF1QipPdDwZmzAUSF32yHP7dpEx_B3SV3HD1T3hK2Leu=w72-h72-n-k-no','4.0');
INSERT INTO "restaurants" VALUES (25,'Las Gringas','Restaurante discreto de pizzas novedosas estilo peruano, desayuno-almuerzo variados y cerveza tirada.','Cercado','https://lh5.googleusercontent.com/p/AF1QipPdDwZmzAUSF32yHP7dpEx_B3SV3HD1T3hK2Leu=w72-h72-n-k-no','4.0');
INSERT INTO "foods" VALUES (1,'Chupe de camarones','Este es uno de los platos típicos de Arequipa y uno de los más servidos en las picanterías de esta ciudad. Es una sopa picante que combina entre sus ingredientes: camarones de río, papa amarilla, queso, leche, maíces y un aderezo de ají y huacatay que le da un sabor auténtico. Ideal para personas que disfrutan lo picante y son amantes de los camarones. ',15.0,'https://blog.casa-andina.com/wp-content/uploads/2020/10/Chupe-de-camarones-El-Comercio.jpg',1,'Dimas','4.0');
INSERT INTO "foods" VALUES (2,'Rocoto relleno','Este es uno de los platos banderas de la Ciudad Blanca, que incluso ha logrado traspasar fronteras gracias a su exquisito sabor. Da honor a su nombre ya que su propuesta incluye un rocoto relleno de carne molida mezclada con guisantes, aceitunas, queso fresco y otras especies que hacen de éste un plato de sabor inigualable. Suele ir acompañado de pastel de papa, lo que provoca una combinación que te enamorará por completo. ',10.0,'https://blog.casa-andina.com/wp-content/uploads/2020/10/Rocoto-relleno-La-Plaza-Bar-Grill-Arequipa.jpg',1,'Dimas','5.0');
INSERT INTO "foods" VALUES (3,'Rocoto relleno','Este es uno de los platos banderas de la Ciudad Blanca, que incluso ha logrado traspasar fronteras gracias a su exquisito sabor. Da honor a su nombre ya que su propuesta incluye un rocoto relleno de carne molida mezclada con guisantes, aceitunas, queso fresco y otras especies que hacen de éste un plato de sabor inigualable. Suele ir acompañado de pastel de papa, lo que provoca una combinación que te enamorará por completo. ',8.0,'https://blog.casa-andina.com/wp-content/uploads/2020/10/Rocoto-relleno-La-Plaza-Bar-Grill-Arequipa.jpg',2,'Las Gringas','3.0');
INSERT INTO "foods" VALUES (4,'Adobo arequipeño','De acuerdo con la tradición arequipeña este es un plato que se come los domingos. Preparado en base a lomo de cerdo con una salsa que combina ají molido, cebolla, chicha de jora y otros condimentos. Este plato se caracteriza por su tierna y jugosa carne y su consistencia espesa, además suele ir acompañado por pan. La definición de este plato es: picante y sabroso',20.0,'https://blog.casa-andina.com/wp-content/uploads/2020/10/Adobo-arequipeno-Abrecht.jpg',2,'Las Gringas','7.0');
INSERT INTO "foods" VALUES (5,'Chupe de camarones','Este es uno de los platos típicos de Arequipa y uno de los más servidos en las picanterías de esta ciudad. Es una sopa picante que combina entre sus ingredientes: camarones de río, papa amarilla, queso, leche, maíces y un aderezo de ají y huacatay que le da un sabor auténtico. Ideal para personas que disfrutan lo picante y son amantes de los camarones. ',12.0,'https://blog.casa-andina.com/wp-content/uploads/2020/10/Chupe-de-camarones-El-Comercio.jpg',3,'Pasta Canteen','5.0');
INSERT INTO "foods" VALUES (6,'Adobo arequipeño','De acuerdo con la tradición arequipeña este es un plato que se come los domingos. Preparado en base a lomo de cerdo con una salsa que combina ají molido, cebolla, chicha de jora y otros condimentos. Este plato se caracteriza por su tierna y jugosa carne y su consistencia espesa, además suele ir acompañado por pan. La definición de este plato es: picante y sabroso',15.0,'https://blog.casa-andina.com/wp-content/uploads/2020/10/Rocoto-relleno-La-Plaza-Bar-Grill-Arequipa.jpg',3,'Pasta Canteen','6.0');
INSERT INTO "orders" VALUES (1,'24/05','Luis',1,25.0);
INSERT INTO "orders" VALUES (2,'23/05','Luis',3,20.0);
INSERT INTO "orders" VALUES (3,'Hoy','Luis',2,150.0);
COMMIT;
