CREATE DATABASE  IF NOT EXISTS `proyecto` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `proyecto`;
-- MariaDB dump 10.17  Distrib 10.4.8-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: proyecto
-- ------------------------------------------------------
-- Server version	10.4.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentarios` (
  `idcomentario` int(11) NOT NULL AUTO_INCREMENT,
  `textocomentario` varchar(255) DEFAULT NULL,
  `fechacreacion` date DEFAULT NULL,
  `idusuario` int(11) NOT NULL,
  `idpost` int(11) NOT NULL,
  PRIMARY KEY (`idcomentario`),
  KEY `fk_comentario_post_idx` (`idpost`),
  KEY `fk_comentario_usuario_idx` (`idusuario`),
  CONSTRAINT `fk_comentario_post` FOREIGN KEY (`idpost`) REFERENCES `post` (`idpost`),
  CONSTRAINT `fk_comentario_usuario` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios`
--

LOCK TABLES `comentarios` WRITE;
/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
INSERT INTO `comentarios` VALUES (54,'que idea mas chula','2021-04-10',34,5),(55,'maravilloso','2021-04-10',34,5),(71,'Es una idea genial. De una simple caja podemos hacer cosas chulisimas','2021-04-13',35,1),(72,'Yo tambi??n he reciclado cajas de fruta, en lugar de como macetero para hacer unas estanter??as muy chulas. ','2021-04-13',34,1),(86,'Me encanta muchismo','2021-05-19',38,5),(91,'Una  idea genial para reciclar botes de cristal.','2021-05-27',34,36);
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `idpost` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `resumen` varchar(1000) NOT NULL,
  `texto` varchar(5000) NOT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `fechacreacion` date NOT NULL,
  PRIMARY KEY (`idpost`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'CAJA DE FRUTA DECORADA','Dale una segunda vida a las cajas de madera','<p>Como hab??is podido comprobar en &nbsp;las manualidades &nbsp;publicadas en este blog, el reciclado de objetos cotidianos pasa a formar parte de la decoraci??n de nuestro hogar. Hoy vamos a centrarnos en el reciclaje y decoraci??n de una caja de fruta-</p><p>Para llevar a cabo este proyecto necesitaremos:</p><ul><li>una caja de fruta de madera</li><li>pegamento</li><li>lija grano fino</li><li>barniz de fijaci??n</li><li>pintura del color que queramos</li><li>distintos adornos al gusto</li></ul><p>En este caso la vamos a utilizar de macetero pero los usos que se le pueden dar son m??ltiples.</p><p>Comenzaremos lijando la caja para eliminar posibles astillas e impurezas. A continuaci??n pintaremos del color deseado dejando secar entre capa y capa en el caso de necesitar mas de una mano de pintura o de usar distintos colores superpuestos.</p><p>Luego daremos un barniz para fijar y proteger el color. Finalmente pegaremos los adornos a nuestro gusto</p>','caja.jpg','2020-10-15'),(2,'COSTURERO','Fabrica tu propio costurero con una caja','<p>Muchas veces tenemos nuestros utensilios de costura por un lado y otro de forma desorganizada. Hoy vamos a crear nuestro propio costurero de una forma f??cil.</p><p>Materiales:</p><ul><li>caja de madera, aunque tambi??n nos servir??a una de cart??n</li><li>lija grano fino</li><li>pintura del color deseado</li><li>barniz fijaci??n</li><li>plantillas para adornos</li></ul><p>Si nuestra caja es de madera comenzaremos lijando un poco la superficie de la misma, en caso de una caja de cart??n podemos saltarnos este paso.</p><p>Luego pintaremos del color que mas nos guste. Una vez este la pintura seca utilizaremos una plantilla para hacer peque??os dibujos que adornar??n nuestro costurero. En el mercado existen infinidad de platillas que podemos usar.</p><p>Cuando todo este bien seco daremos una mano de barniz para proteger.</p>','costurero.jpg','2020-10-21'),(3,'MARCO DE FOTOS','Crea un precioso marco de fotos de una forma sencilla','<p>Con tan solo unos pocos materiales puedes crear un maravilloso marco de fotos-</p><p>Materiales</p><ul><li>cart??n de gramaje duro</li><li>papel de colores</li><li>tijera</li><li>pegamento</li></ul><p>Lo primero cortaremos el cart??n con el tama??o que queramos para nuestro portafotos, en mi caso 15 x 20 cm. Cuando tengamos el cart??n recortado y el hueco para la foto hecho lo siguiente ser?? adornar con nuestro papel de colores. vamos pegando alrededor del marco el papel e incluso adornos como flores, conchas, perlitas o similar</p>','marco.jpg','2020-11-15'),(5,'ORGANIZADOR CON TETRABRIKS','Crea un organizador para pinceles, agujas, l??pices, cables, y todo lo quieras tener ordenado reutilizando un envase de tetrabrik vac??o','<p>Para hacer este organizador lo primero ser?? reunir todos los materiales:&nbsp;</p><ul><li>Tijera&nbsp;</li><li>Tetrabrik&nbsp;</li><li>Pegamento&nbsp;</li><li>Goma&nbsp;</li><li>Regla de medir&nbsp;</li><li>Tela&nbsp;</li></ul><p>Una vez tenemos todos los materiales pelamos el tetrabrik. A continuaci??n pega en el cart??n la tela que mas te guste. Coses las gomas y un lazo para el cierre y ya tenemos nuestro organizador</p>','organizador.jpg','2020-12-30'),(36,'CANDELABROS','Bonitos candelabros con botes de cristal','<p>Aqu?? le mostramos una idea para hacer sus propios candelabros. Son incre??blemente f??ciles de hacer. La luz es parte muy importante de la decoraci??n de su hogar. El uso de velas, como una pieza de decoraci??n le ayudara a obtener un aspecto encantador. La atm??sfera confortable es otra de las caracter??sticas de las velas.&nbsp;</p><p>Los materiales necesarios son:</p><ul><li>bote de cristal</li><li>vela</li><li>hojas secas</li><li>pegamento</li><li>cinta para decorar</li></ul><p>Para la creaci??n de este candelabro de hojas, s??lo debe sumergir su cepillo en el pegamento y hacer una la capa delgada en la parte interior de la jarra. Una vez que la capa se vuelve muy pegajosa, coloque las hojas una por una. Repita los pasos y deje que se seque por completo. Termine la parte superior del frasco con rafia o cinta para completar el aspecto. Coloque una vela dentro para llenar &nbsp;habitaci??n con hermosos colores naranja, rojo y verde de oto??o.</p>','candelabros.jpg','2021-03-25'),(43,'GUIRNALDA DE HALLOWEEN','Hoy traemos un tutorial para hacer una guirnalda de Halloween con goma Eva y cord??n de yute.','<p>Para esta guirnalda hemos creado varias siluetas de calabazas, fantasmas y murci??lagos.</p><p>Esta&nbsp;idea sencilla y econ??mica va muy bien para ambientar fiestas de Halloween.</p><p>Podemos colgarla en alguna puerta o en las paredes. Incluso podemos&nbsp;hacerla m??s grande y colarla de una punta a otra de la habitaci??n.</p><p>A continuaci??n te dejamos la lista de materiales que hemos utilizado:</p><ul><li><a href=\"https://conideade.com/63-goma-eva\">Goma Eva</a> (negra, naranja y blanca)</li><li>Tijeras puntiagudas</li><li><a href=\"https://conideade.com/cordones-hilos/1369-cordon-de-yute-de-1-mm.html\">Cord??n de yute</a></li><li>Plantillas</li></ul><p><strong>1-&nbsp;</strong>Lo primero que necesitamos para nuestra guirnalda son unas plantillas para hacer las siluetas. Nosotros hemos hecho tres diferentes: un <a href=\"https://conideade.com/blog/wp-content/uploads/2017/07/murcielago.pdf\">murci??lago</a>, una <a href=\"https://conideade.com/blog/wp-content/uploads/2017/07/calabaza.pdf\">calabaza</a> y un <a href=\"https://conideade.com/blog/wp-content/uploads/2017/07/fantasma.pdf\">fantasma</a>.</p><p><strong>2-</strong> Una vez tengamos las plantillas recortadas, calcamos las siluetas en la goma eva.</p><p>Vamos a caracterizar cada silueta con el color al que se le asocia.</p><p>As?? que utilizaremos goma eva negra para los murci??lagos, naranja para las calabazas y blanca para los fantasmas.</p><p><strong>3-</strong> Para marcar las siluetas en la goma eva utilizamos alguna herramienta con punta fina.</p><p>As?? no se quedar?? ninguna marca de bol??grafo. Nosotros hemos usado la punta de las tijeras Softgrip.</p><p><strong>4-</strong> Cuando hayamos marcado las formas que vamos a necesitar, las recortamos para poder ir coloc??ndolas despu??s en el cord??n.</p><p><strong>5-</strong> Recortamos tantas siluetas como hagan falta para completar la guirnalda. Esto depender?? del tama??o que le queramos dar.</p><p><strong>6-</strong> Por ??ltimo vamos introduciendo las figuras en el cord??n de yute.</p><p>Utilizamos los ojos de las siluetas como agujeros para introducir la cuerda. Lo pasamos de manera que el cord??n solo se vea por delante de la goma Eva en el hueco entre los dos ojos.</p><p>Con estos sencillos pasos tendremos nuestra guirnalda de Halloween de goma eva lista para colocar donde queramos.</p>','halloween.jpg','2021-02-19'),(44,'PEONIA DE GOMA EVA','El d??a de la madre se acerca y queremos compartir esta idea de regalo contigo: una peonia de goma Eva.','<p>Las flores siempre son un regalo recurrente para d??as tan bonitos como este.</p><p>Por eso esta flor de foamy nos parece perfecta para recordar a nuestras madres lo importantes que son.</p><p>Esta creaci??n handmade tiene la ventaja de que no puede marchitarse.</p><p>A continuaci??n os dejo un listado con los enlaces a los productos utilizados para hacer este tutorial:</p><ul><li><a href=\"https://conideade.com/goma-eva/412-goma-eva-de-1mm-20-colores.html?search_query=goma+eva&amp;results=147\">Goma Eva</a>: rosa, verde y amarillo</li><li><a href=\"https://conideade.com/washi-tape/2897-cinta-para-floristeria-floral-tape-verde.html?search_query=alambre&amp;results=18\">Cinta floral</a></li><li><a href=\"https://conideade.com/8-alambre-manualidades\">Alambre</a> de aluminio</li><li><a href=\"https://conideade.com/pinturas/1758-pintura-acrilica-artis-60-ml.html\">Pinturas acr??licas</a>: rosa, verde y amarillo.</li><li><a href=\"https://conideade.com/pegamentos/3459-12-barras-de-silicona-para-pistola-mini.html\">Silicona caliente</a></li><li><a href=\"https://conideade.com/131-plantillas-pinceles-y-herramientas-para-decoupage\">Pinceles</a></li></ul><p>Ya sabes todo lo que se necesita saber sobre la goma eva y tienes los materiales listos, pues ahora toca ponerse manos a la obra:</p><p><strong>1-</strong> Lo primero que necesitaremos es&nbsp;la plantilla para hacer los&nbsp;<a href=\"https://2.bp.blogspot.com/-INPiogTv-lk/WQemOgCPYEI/AAAAAAAAJbQ/3qydtymTXtEjRzuCq_dPFo-ZRAJub09hACLcB/s1600/Plantillas.jpg\">p??talos</a>.</p><p>Tambi??n pod??is crear vuestra propia plantilla. Recortamos las plantillas y las pasamos a goma Eva de color rosa. O cualquier otro color que hayamos elegido para realizar los p??talos.</p><p><strong>2-</strong> Utilizamos la t??cnica del pincel seco para crear las vetas de los p??talos con un rosa m??s oscuro.</p><p>Cuando est??n pintados por ambos lados, cortamos un trozo de alambre para el tallo.</p><p><strong>3-</strong> Forramos el alambre con cinta floral de color verde. Un truco para que se quede bien fijada la cinta es estirarla un poco mientras la pegamos.</p><p><strong>4-</strong> Rodamos el tallo sobre la mesa para que quede bien recto.</p><p>El siguiente paso es cortar un rect??ngulo amarillo de goma Eva de 15 cm x 2 cm.</p><p><strong>5-</strong> Hacemos flecos estrechos en el rect??ngulo para crear los pistilos de la flor.</p><p>Con silicona caliente lo enrollamos en la punta del tallo verde.</p><p>Con la plancha podemos darle unos toquecitos para que se curven un poco los pistilos.</p><p><strong>6-</strong> Para moldear los p??talos, los colocamos sobre la plancha uno por uno hasta que se&nbsp;abomben.</p><p>De este modo ser??n lo suficientemente flexibles para darles forma con los dedos.</p><p>Cuando tengamos la forma que nos guste, vamos pegando cada p??talo al tallo con silicona caliente.</p><p><strong>7-</strong> Tras pegar todos los p??talos, cortamos las plantillas de las <a href=\"https://1.bp.blogspot.com/-d3ncJjPgiu0/WQemOqgwxpI/AAAAAAAAJbM/5sojuK8Lnq4nM9CqnpzqYNdNKwp8H-mNQCLcB/s1600/peony-leaves-cutter-set-of-3-by-celcakes-31b.jpg\">hojas</a> en la goma Eva verde.</p><p>Definimos&nbsp;las nevaduras de las hojas con un punz??n.</p><p>Con un pincel liner (Un pincel de punta redonda y muy fino) y pintura verde a punto de tinta las marcamos para que queden m??s oscuras que el resto de la hoja.</p><p><strong>8-</strong> Con la t??cnica del pincel seco y pintura verde le damos un poco de textura. Podemos usar un poco de pintura amarilla para iluminar.</p><p><strong>9-</strong> Para moldear y pegar las hojas, repetimos el mismo paso que con los p??talos.</p><p>Cuando todos los p??talos y las hojas est??n pegadas, nuestra <strong>peonia de goma Eva</strong> estar?? lista.</p>','peonia.jpg','2021-04-15'),(45,'POSAVASOS DE MADERA CON DECOUPAGE','En este tutorial os vamos a ense??ar a decorar unos posavasos de madera con decoupage. Es una manualidad muy sencilla de realizar, pero con un resultado de lo m??s ??til y decorativo.','<p>Nosotros hemos usado unos papeles para decoupage decorados con cupcakes, pero pod??is usar cualquier otro motivo.</p><p>Materiales:</p><ul><li><a href=\"https://conideade.com/madera/4010-pack-6-posavasos-de-madera-para-decorar.html\">Posavasos de madera</a></li><li>Papel decoupage cupcakes</li><li>Medium decoupage</li><li>Gesso</li><li>Pintura acr??lica organza</li><li>Barniz satinado</li><li>Goma eva negra</li><li>Silicona fr??a</li><li>Pinceles</li></ul><p>Antes de ponerte manos a la obra con la manualidad recuerda proteger la superficie de trabajo.</p><p>Para ello puedes usar un pl??stico, un cart??n o usar alguno de los tapices <strong>protectores de superficies espec??ficos para manualidades</strong>.</p><p>Con los materiales ya preparados estamos listos para <strong>decorar posavasos de madera con decoupage, </strong>para realizar el trabajo vamos a utilizar un set de <strong>6 posavasos</strong> de madera de 10??10 cent??metros.</p><ul><li>Primero tendremos que <strong>pintar</strong> los posavasos por delante y por detr??s con gesso. El gesso nos permitir?? aplicar <strong>cualquier tipo de producto</strong> a la superficie de la madera y que se adhiera bien, as?? no tendremos <strong>ning??n problema</strong> a la hora de pintar o aplicar alguna cola.</li><li>Cuando el gesso se seque vamos a pintar todos los posavasos con<strong> pintura acr??lica</strong> de la marca Artis Crom??tica en <strong>color organza</strong>.</li><li>Para el <strong>decoupage</strong> vamos a utilizar una l??mina de papel de la marca <strong>Dayka Trade</strong> que viene decorada con unos <strong>cupcakes</strong>. Para ello recortaremos de cada cupcake el nombre y el propio cupcake dejando fuera el borde, que utilizaremos tambi??n m??s adelante.</li><li>Ahora realizaremos el decoupage. Como <strong>pegamento</strong> utilizaremos el medium de la marca Artis Crom??tica.<ul><li>Pondremos un poco de pegamento sobre el posavasos y despu??s vamos acomodando el <strong>cupcake</strong> encima pas??ndole poco a poco el pincel con un poco m??s de pegamento por encima para a continuaci??n poner las <strong>letras</strong> orientadas de la forma que m??s te guste.</li><li>Hacemos lo mismo con <strong>todos los cupcakes.</strong></li><li>Finalmente <strong>pegamos la puntilla de papel</strong> que ten??amos guardada en los <strong>bordes</strong> del posavasos.</li></ul></li><li>Una vez secado el <strong>decoupage</strong> le pasaremos una <strong>lima de u??as o una lija de grano fino</strong> para rematar bien el papel que hemos pegado y que queden bien todas las esquinas unidas.</li><li>Para <strong>proteger</strong> el trabajo vamos a aplicar dos capas de <strong>barniz acr??lico satinado</strong>.<ul><li>Aplicamos una <strong>primera capa</strong> y la dejamos secar durante al menos una hora.</li><li>Y a continuaci??n le aplicamos la <strong>segunda capa</strong>. As?? podremos usar los posavasos sin miedo a estropear el decoupage.</li></ul></li><li>Recortaremos <strong>6 trozos de goma eva</strong> de la misma medida que los posavasos y a continuaci??n pegaremos esos trozos en la parte inferior de cada uno con&nbsp;<strong>silicona&nbsp;fr??a</strong>.<ul><li>Para que se peguen m??s firmemente podemos sujetar la goma eva al posavasos con una <strong>peque??a pinza</strong>.</li></ul></li></ul><p>Y con esto concluimos nuestro tutorial para <strong>decorar posavasos de madera con decoupage</strong>. Esperamos que os guste.</p>','posavasos.jpg','2021-05-29'),(46,'BUH??S NAVIDE??OS CON PI??AS','Hoy volvemos a hablarte de manualidades navide??as, y es que estamos a punto de finalizar noviembre, y es justo ahora cuando comenzamos a ver la decoraci??n de estas fechas en venta en las principales tiendas.','<p>Nosotros hoy queremos ense??arte <strong>c??mo hacer unos b??hos navide??os con pi??as</strong> que quedar??n estupendos en cualquier rinc??n de tu casa. ??Qu?? te parece la idea? ??All?? vamos!</p><p>C??mo puedes ver los materiales son muy sencillos, simplemente pi??as recicladas y algunos materiales para manualidades b??sicos.</p><ul><li>Pi??as naturales</li><li><a href=\"https://conideade.com/51-fieltro\"><strong>Fieltro</strong></a></li><li>Ojos m??viles</li><li>Pegamento para manualidades</li><li>Limpia pipas</li></ul><p>Lo primero que debemos hacer es cortar las que ser??n las <strong>alas del b??ho</strong>, el pecho y la cabeza; las haremos con fieltro.</p><p>La opci??n m??s sencilla es la de optar por una especie de coraz??n apaisado para la cabeza, unos ??valos de dos tama??os para las alas, y en el caso del pecho un c??rculo.</p><p>Luego tendr??s que cortar algunos <strong>detalles</strong> como el pico&nbsp;o las manchas que se colocar??n en varios lugares.</p><p><strong>Los ojos</strong>, nosotras preferimos que sean m??viles, pero puedes hacerlos tambi??n con fieltro o incluso pintarlos con pintura textil.</p><p>En cuanto tengas todo, solo quedar?? pegar las piezas a la pi??a con el pegamento. <strong>Para las patas</strong>, modela los limpiapipas y p??galos en la base asegur??ndote de que se sostiene. ??F??cil, no?</p>','buhos.jpg','2020-11-29'),(47,'PERCHA INFANTIL CECORADA','Hoy os vamos a mostrar como decorar una percha infantil decorada con pintura Chalk y una silueta de madera; en este caso hemos elegido un b??ho, pero ya sab??is que dando rienda suelta a vuestra imaginaci??n pod??is usar todo tipo de materiales para manualidades que se os ocurra.','<p>Esta percha es ideal para decorar un dormitorio infantil, una habitaci??n de juegos o para usar en el armario de los m??s peque??os de la casa.</p><p>Para hacer tu propia percha infantil decorada necesitar??s:</p><ul><li><a href=\"https://conideade.com/scrapbooking/4733-percha-de-madera-infantil.html\">Percha de madera</a> de 30 cm</li><li><a href=\"https://conideade.com/siluetas/2543-set-de-silueta-de-madera-2-buhos-chica.html\">Siluetas de madera b??hos</a></li><li><a href=\"https://conideade.com/pinturas/3854-pintura-chalky-effect-artis-decor-60-ml.html\">Pintura a la tiza chalk paint</a> marfil, jazmin, cuarzo, rubor, amarillo, menta y negro</li><li><a href=\"https://conideade.com/214-pinceles-manualidades\">Pinceles</a></li><li><a href=\"https://conideade.com/barnices-manualidades/2334-barniz-al-agua-satinado-60-ml.html\">Barniz acrilico satinado</a></li><li><a href=\"https://conideade.com/pegamentos/3458-mini-pistola-de-silicona-25-w.html?search_query=pistola&amp;results=45\">Pistola</a> y&nbsp; <a href=\"https://conideade.com/pegamentos/3459-12-barras-de-silicona-para-pistola-mini.html?search_query=pistola&amp;results=45\">silicona caliente</a></li></ul><ol><li>El primer paso es <strong>pintar la percha de madera</strong> con pintura chalk paint como ya sab??is con la pintura a la tiza no es necesario dar imprimaci??n primero, con lo que pintamos directamente sobre la percha, en este caso lo hacemos con el color marfil.</li><li>Ahora mientras esperamos a que seque la percha <strong>vamos a pintar las siluetas de los b??hos</strong>; comenzamos pintando el cuerpo del b??ho grande en color cuarzo, para pintar los ojos vamos a necesitar pintura jazm??n para la parte exterior del ojo&nbsp; y negra para la parte interior. Con el color rubor vamos a pintar la parte del inferior del b??ho grande y el cuerpo del b??ho peque??o. De color amarillo pintamos el pico y las patitas y de color menta el lazo de la cabeza, ahora solo nos queda pintarle unas plumitas con pintura de color jazm??n y rubor.</li><li>A continuaci??n vamos a decorar la percha infantil que hab??amos pintado de marfil, haci??ndoles <strong>topitos</strong> en varios tonos (cuarzo y rubor) por toda la percha.</li><li>Una vez este seca la decoraci??n de nuestra percha infantil vamos a <strong>pegar los b??hos con la pistola de silicona caliente</strong>, nosotros hemos colocado el b??ho grande delante y el peque??o detr??s.</li><li>Y para terminar y proteger nuestra maravillosa percha infantil decorada vamos <strong>aplicar una capa de barniz acr??lico</strong> satinado.</li></ol><p><br>&nbsp;</p>','perchaInfantil.jpg','2021-01-29');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postfavoritos`
--

DROP TABLE IF EXISTS `postfavoritos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postfavoritos` (
  `idpost` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  `idusuariopost` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idusuariopost`),
  KEY `fk_favoritos_post_idx` (`idpost`),
  KEY `fk_favoritos_usuario_idx` (`idusuario`),
  CONSTRAINT `fk_favoritos_post` FOREIGN KEY (`idpost`) REFERENCES `post` (`idpost`),
  CONSTRAINT `fk_favoritos_usuario` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postfavoritos`
--

LOCK TABLES `postfavoritos` WRITE;
/*!40000 ALTER TABLE `postfavoritos` DISABLE KEYS */;
INSERT INTO `postfavoritos` VALUES (3,34,86),(1,34,103);
/*!40000 ALTER TABLE `postfavoritos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `idrol` int(11) NOT NULL AUTO_INCREMENT,
  `desrol` varchar(45) NOT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMINISTRADOR'),(2,'ROLE_REGISTRADO');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` int(9) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `contrasena` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `UKkfsp0s1tflm1cwlj8idhqsad0` (`email`),
  UNIQUE KEY `UKivkakkw3fsaiocid4i7yrnnx` (`contrasena`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (34,'Paula','Garcia Suarez','villoriaponton@gmail.com',663783575,'Plaza el Progreso 3, 2??D Blimea (San Mart??n del Rey Aurelio)','$2a$10$BKELRzxLEBbNPPmPh7zM2.l.i/megB0xEoILms1RJtJQ1Xn3k7eIG'),(35,'Javier','Peon Antolin','javipeon84@hotmail.com',646942788,'Calle el Ponton 25A','$2a$10$SSllUQySOgv3DnyXRAU9quaV/8z3tk2eb9yY3DiwmyPEv9QZHaJAq'),(38,'Mis Manitas','Administrador','blogmismanitas@gmail.com',663485236,'Plaza Arturo Rey 25, Oviedo','$2a$10$aZ55DGCVMCYS3cmYMgOo1.GpQdf5394oKf4Pf5X2qG0e.aF.aoT9.');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariosroles`
--

DROP TABLE IF EXISTS `usuariosroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuariosroles` (
  `idusuario` int(11) DEFAULT NULL,
  `idrol` int(11) DEFAULT NULL,
  `idusuariorol` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idusuariorol`),
  KEY `fk_rol_idx` (`idrol`),
  KEY `fk_usuario_idx` (`idusuario`),
  CONSTRAINT `fk_rol` FOREIGN KEY (`idrol`) REFERENCES `roles` (`idRol`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariosroles`
--

LOCK TABLES `usuariosroles` WRITE;
/*!40000 ALTER TABLE `usuariosroles` DISABLE KEYS */;
INSERT INTO `usuariosroles` VALUES (34,2,24),(35,2,26),(38,1,29),(38,2,32);
/*!40000 ALTER TABLE `usuariosroles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-31 18:33:40
