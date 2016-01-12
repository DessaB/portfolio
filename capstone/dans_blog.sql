-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 19, 2015 at 09:12 AM
-- Server version: 5.5.46-0ubuntu0.14.04.2
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dans_blog`
--

-- --------------------------------------------------------

--
-- Table structure for table `announcement`
--

CREATE TABLE IF NOT EXISTS `announcement` (
  `announcement_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `publish_date` date NOT NULL,
  `expiry_date` date NOT NULL,
  PRIMARY KEY (`announcement_id`),
  UNIQUE KEY `announcement_id` (`announcement_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `announcement`
--

INSERT INTO `announcement` (`announcement_id`, `content`, `publish_date`, `expiry_date`) VALUES
(7, '<p>Well, the way they make shows is, they make one show. That show''s called a pilot. Then they show that show to the people who make shows, and on the strength of that one show they decide if they''re going to make more shows. Some pilots get picked and become television programs. Some don''t, become nothing. She starred in one of the ones that became nothing.</p>', '2015-11-18', '2015-11-30'),
(8, '<p>much sit! want design, so ipsum. yes master doge, want full. go swag, i can haz word! many layout! plz dolor, much layout, so ipsum. plz full. oh my ipsum. very design. very design. want full. much layout, very word, much text! yes master doge. very lorem! go swag, so ipsum. want design, plz dolor, want full. go doge. i iz cute?! much layout, much layout, so adipiscing, very word, oh my layout! very lorem! yes master doge! wow. need amet. oh my ipsum. rate me! wow. plz lorem! much sit! very swag. so adipiscing, much sit! yes master doge. so doge! such aenean! much doge, wow. wow.&nbsp;</p>', '2015-11-18', '3000-01-01');

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(20) NOT NULL,
  `authority` varchar(20) NOT NULL,
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('test', 'ROLE_ADMIN'),
('test', 'ROLE_USER'),
('test2', 'ROLE_USER'),
('admin', 'ROLE_ADMIN'),
('blogger', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `blog_category`
--

CREATE TABLE IF NOT EXISTS `blog_category` (
  `blog_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  KEY `blog_id` (`blog_id`),
  KEY `user_id` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blog_category`
--

INSERT INTO `blog_category` (`blog_id`, `category_id`) VALUES
(22, 8),
(22, 9),
(23, 10),
(23, 11),
(24, 12);

-- --------------------------------------------------------

--
-- Table structure for table `blog_post`
--

CREATE TABLE IF NOT EXISTS `blog_post` (
  `blog_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `title` varchar(50) NOT NULL,
  `submitted` tinyint(1) NOT NULL,
  `creation_date` date NOT NULL,
  `publish_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `blog_post`
--

INSERT INTO `blog_post` (`blog_id`, `user_id`, `title`, `submitted`, `creation_date`, `publish_date`, `expiry_date`, `content`) VALUES
(22, 1, 'Hipster Lunch', 0, '2015-11-17', '2015-11-18', '3000-01-01', '<p style="box-sizing: border-box; margin: 0px 0px 1.1em; padding: 0px; border: 0px; font-size: 17.2px; line-height: 29.24px; font-family: Lato, sans-serif; color: rgb(68, 68, 68);">Actually pork belly nostrud, pinterest tilde bushwick umami. Vinyl DIY viral seitan. Art party tumblr forage ea, ethical farm-to-table actually ullamco. Irony pabst kinfolk, et elit readymade post-ironic disrupt forage. Bicycle rights dolor cupidatat pinterest, polaroid salvia migas kombucha yr. Ex locavore everyday carry voluptate, PBR&amp;B mustache echo park street art DIY keytar magna scenester. Beard leggings seitan hella, disrupt aliquip small batch organic nulla anim banjo fugiat retro.</p><p style="box-sizing: border-box; margin: 0px 0px 1.1em; padding: 0px; border: 0px; font-size: 17.2px; line-height: 29.24px; font-family: Lato, sans-serif; color: rgb(68, 68, 68);">Forage non disrupt, laborum exercitation minim art party scenester accusamus keffiyeh stumptown kitsch. Blue bottle leggings VHS selvage gastropub. Bespoke ugh culpa, truffaut gentrify organic quinoa aliquip taxidermy minim irony waistcoat bushwick fingerstache. Gentrify non bicycle rights semiotics skateboard, roof party helvetica salvia mustache portland nihil pinterest fashion axe consectetur. Seitan meggings 8-bit, elit proident distillery next level kale chips wayfarers dolor hoodie pinterest irure. Everyday carry single-origin coffee poutine, mumblecore you probably haven''t heard of them placeat humblebrag intelligentsia pitchfork fap. Shabby chic velit venmo, fixie banjo fashion axe salvia beard cronut heirloom est placeat plaid food truck aliquip.</p><p style="box-sizing: border-box; margin: 0px 0px 1.1em; padding: 0px; border: 0px; font-size: 17.2px; line-height: 29.24px; font-family: Lato, sans-serif; color: rgb(68, 68, 68);">Keytar exercitation slow-carb try-hard, photo booth esse kogi offal skateboard lo-fi. Twee you probably haven''t heard of them pork belly poutine, meggings celiac literally irure. Put a bird on it kogi skateboard, street art thundercats plaid ramps chillwave helvetica umami esse. Umami single-origin coffee gastropub, veniam neutra pork belly proident pug kogi health goth. Waistcoat trust fund everyday carry actually, echo park umami cupidatat before they sold out small batch narwhal nulla. Photo booth gluten-free consequat, craft beer brooklyn magna deep v sartorial do pinterest irure blue bottle microdosing banh mi dreamcatcher. Commodo shabby chic trust fund, dreamcatcher cardigan roof party everyday carry bicycle rights.</p><p style="box-sizing: border-box; margin: 0px; padding: 0px; border: 0px; font-size: 17.2px; line-height: 29.24px; font-family: Lato, sans-serif; color: rgb(68, 68, 68);">Seitan assumenda magna swag dolor, bicycle rights typewriter voluptate. Synth chillwave artisan austin, seitan chartreuse master cleanse meggings truffaut mustache four loko. Dolor hella art party artisan commodo. VHS taxidermy cupidatat, meditation try-hard kitsch authentic chillwave four dollar toast enim farm-to-table vero seitan iPhone velit. Crucifix elit godard actually, fingerstache chia mlkshk waistcoat. Meh dolor tattooed qui, pariatur tacos chicharrones eiusmod artisan ugh marfa chambray dreamcatcher raw denim. Kombucha lomo banjo XOXO, fap photo booth fugiat gluten-free pinterest stumptown distillery est etsy.</p>'),
(23, 1, 'Biking with Danny', 0, '2015-11-17', '2015-11-18', '3000-01-01', '<p><span style="font-family: ''Trebuchet MS'', verdana, sans-serif; font-size: 14.6667px;">Readymade marfa blog, pitchfork food truck tofu jean shorts homo organic photo booth scenester. Thundercats keytar terry richardson, biodiesel banksy food truck leggings high life gluten-free locavore american apparel freegan whatever photo booth. Brunch high life wes anderson trust fund, jean shorts mustache DIY single-origin coffee four loko. Readymade retro tattooed single-origin coffee butcher seitan beard artisan. Tattooed keffiyeh banh mi hoodie, vinyl gluten-free art party put a bird on it salvia butcher +1 portland helvetica craft beer wayfarers. Mustache beard four loko craft beer tumblr. Iphone seitan shoreditch, wolf next level vegan wes anderson leggings bicycle rights dreamcatcher.&nbsp;</span><br style="font-family: ''Trebuchet MS'', verdana, sans-serif; font-size: 14.6667px;"><br style="font-family: ''Trebuchet MS'', verdana, sans-serif; font-size: 14.6667px;"><span style="font-family: ''Trebuchet MS'', verdana, sans-serif; font-size: 14.6667px;">Letterpress jean shorts helvetica locavore mustache squid. Organic tofu retro, williamsburg seitan mcsweeney''s sartorial irony ethical. You probably haven''t heard of them twee single-origin coffee freegan biodiesel, ethical echo park before they sold out high life. Dreamcatcher Austin next level, beard brunch master cleanse hoodie keytar raw denim squid VHS seitan etsy. Pitchfork master cleanse jean shorts artisan, skateboard four loko keffiyeh butcher gentrify sartorial. Master cleanse sartorial cred shoreditch, etsy portland +1 PBR. +1 vinyl terry richardson, mustache dreamcatcher cred retro food truck brunch thundercats.&nbsp;</span><br style="font-family: ''Trebuchet MS'', verdana, sans-serif; font-size: 14.6667px;"><br style="font-family: ''Trebuchet MS'', verdana, sans-serif; font-size: 14.6667px;"><span style="font-family: ''Trebuchet MS'', verdana, sans-serif; font-size: 14.6667px;">Mixtape seitan keffiyeh dreamcatcher PBR terry richardson. Food truck raw denim irony photo booth before they sold out. Terry richardson you probably haven''t heard of them fixie sartorial put a bird on it. Mustache mixtape squid, mcsweeney''s keffiyeh seitan irony photo booth readymade you probably haven''t heard of them master cleanse. Readymade craft beer wolf carles, single-origin coffee synth letterpress cardigan trust fund photo booth before they sold out banksy DIY put a bird on it irony. Craft beer homo brunch, trust fund aesthetic seitan williamsburg whatever squid put a bird on it cosby sweater wolf shoreditch mustache letterpress. Banh mi butcher etsy, mlkshk fap before they sold out bicycle rights viral vinyl.&nbsp;</span><br style="font-family: ''Trebuchet MS'', verdana, sans-serif; font-size: 14.6667px;"></p>'),
(24, 1, 'Bacon!', 0, '2015-11-17', '2015-11-18', '2015-12-24', '<p style="box-sizing: border-box; margin: 0px 0px 24px; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(51, 51, 51); font-family: Georgia, ''Bitstream Charter'', serif; font-size: 16px; line-height: 24px; background-image: initial; background-attachment: initial; background-size: initial; background-origin: initial; background-clip: initial; background-position: initial; background-repeat: initial;">Bacon ipsum dolor amet non pork loin quis ham hock, labore aliqua est turducken picanha prosciutto kielbasa swine pancetta. Sausage capicola in dolor short ribs pancetta hamburger shank t-bone prosciutto tri-tip strip steak meatball. Beef ribs ground round jowl sint excepteur short ribs incididunt ea ut adipisicing bacon strip steak in. Corned beef elit cupim sunt ut. Short loin enim irure, brisket aliqua incididunt ham hock dolore tri-tip.</p><p style="box-sizing: border-box; margin: 0px 0px 24px; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(51, 51, 51); font-family: Georgia, ''Bitstream Charter'', serif; font-size: 16px; line-height: 24px; background-image: initial; background-attachment: initial; background-size: initial; background-origin: initial; background-clip: initial; background-position: initial; background-repeat: initial;">Nisi sunt id short loin. Irure sed cupim, porchetta cow shank ball tip dolore shoulder prosciutto aliqua. Incididunt rump shank, swine elit ut enim turkey bacon hamburger chicken tongue. Porchetta cillum eiusmod filet mignon prosciutto esse.</p><p style="box-sizing: border-box; margin: 0px 0px 24px; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(51, 51, 51); font-family: Georgia, ''Bitstream Charter'', serif; font-size: 16px; line-height: 24px; background-image: initial; background-attachment: initial; background-size: initial; background-origin: initial; background-clip: initial; background-position: initial; background-repeat: initial;">Enim dolore andouille fatback deserunt meatball aliquip capicola proident labore sirloin ut. Duis pastrami et sausage, pork sint short ribs sunt. Quis fatback ex kevin. Eiusmod ex brisket, in aute excepteur jerky sausage cillum duis ut laboris. Frankfurter ex nulla fugiat shoulder veniam short ribs cow ullamco ribeye corned beef pig.</p>');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(50) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category`) VALUES
(8, 'key-tar'),
(9, 'fingerstache'),
(10, 'homo-brunch'),
(11, 'wolf-carles'),
(12, 'fat piggy');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `enabled`) VALUES
(1, 'test', 'password', 1),
(2, 'test2', 'password', 1),
(3, 'admin', 'dannyboy', 1),
(4, 'blogger', 'ghostie', 2);

-- --------------------------------------------------------

--
-- Table structure for table `web_pages`
--

CREATE TABLE IF NOT EXISTS `web_pages` (
  `page_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`page_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `web_pages`
--

INSERT INTO `web_pages` (`page_id`, `title`, `content`) VALUES
(1, 'Don''t Be a Wench', 'Shiver me timbers American Main Yellow Jack pillage Nelsons folly Davy Jones'' Locker scourge of the seven seas quarterdeck draught jury mast. Splice the main brace yawl hornswaggle flogging ho quarter doubloon mutiny coffer killick. Corsair Privateer handsomely nipperkin holystone belay provost black jack gaff schooner.\r\nClap of thunder sutler spike Plate Fleet lugger bilge water furl Buccaneer poop deck cutlass. Lugsail weigh anchor tackle take a caulk broadside bowsprit belay tender killick Blimey. Heave to hogshead scuppers pillage tender Sink me blow the man down to go on account long clothes gally.\r\nYardarm crack Jennys tea cup hornswaggle gangplank hulk ahoy draught Shiver me timbers pink gangway. Spanker strike colors draught mizzen fluke rum rigging cable Corsair pink. Spike bucko skysail sutler spyglass haul wind walk the plank hulk loaded to the gunwalls Sea Legs.'),
(2, 'Jabba the Hutt Speaks', '<p>Lucas ipsum dolor sit amet kenobi moff skywalker skywalker amidala c-3po dooku skywalker lars solo. Secura darth jade sebulba hutt. Kenobi aayla jade fisto. Binks organa secura obi-wan kamino. Boba maul skywalker moff. Ewok darth lobot darth ponda solo mandalorians mothma. Maul organa grievous vader darth solo. Skywalker gamorrean skywalker sidious binks. Solo watto binks coruscant vader darth. Dagobah solo jar mace. Wedge darth calamari kashyyyk mace moff kenobi coruscant. Mandalorians yoda moff solo yoda hutt jawa chewbacca.</p><p>Jinn c-3p0 mace kessel lando coruscant. Mara yoda moff endor. Dooku wedge hoth solo. Dooku lando thrawn skywalker organa wedge kashyyyk jinn baba. Mace gamorrean skywalker jabba. Thrawn ewok tatooine watto. Leia wampa ackbar jinn zabrak hutt. Luuke r2-d2 palpatine mon lars twi''lek solo organa wampa. Organa luuke yavin yavin organa kessel kenobi jabba. Jabba darth mandalorians coruscant darth anakin calamari. Twi''lek gonk luke darth binks thrawn. Darth hutt organa boba. Dagobah solo mustafar boba dantooine dooku hutt maul.</p><p>Chewbacca maul ventress darth grievous owen. Boba r2-d2 ventress mon biggs. Secura naboo sith ackbar. Vader lobot hutt obi-wan. Darth kenobi binks endor. Lando jar biggs amidala c-3po skywalker antilles. Ahsoka kessel skywalker luke darth ackbar greedo. Hutt dagobah coruscant luke ackbar skywalker jango. Twi''lek anakin yavin hutt solo. Utapau antilles owen r2-d2 organa. Thrawn mon darth mandalore anakin tatooine c-3po. Wedge boba yoda wedge antilles darth biggs. Alderaan antilles darth darth kessel obi-wan hoth anakin leia.</p>'),
(3, 'Gag Me, Seriously', '<p><span style="color: rgb(34, 34, 34); font-family: ''Helvetica Neue Medium Condensed'', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 18px;">Asian dog college superhero amnesia why y u no finals meme. Gentlemen so close eat bra mom woman facepalm hac. Not bad oboma easter i see what you did there right monday gasp megusta michelle. The avengers mother cookie monster trolololo bacon on lois for aww yeah okay nap scumbag. Good guy i know that feel wodka poker face face cereal guy happy crying sit. Computer dead nyan cat impossibru sandwich hammer grin coffee games challenge accepted. Pokeman no bad silent hill star wars party cellphone panda win drink grey. Sister unlock viverra peter griffin hulk friendzoned feel like a sir bear one does not simply collection. Just essay super rage in class.</span><br data-mce-bogus="1"></p>');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
