<%@ page language="java" contentType="text/html; charset=UTF-8"
import="com.sadden.lucene.*"
import="sadden.wenzhai.servelet.*" import="java.util.*"
import="sadden.wenzhai.action.*"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Search Content</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="i/favicon.png">
<link rel="stylesheet" href="css/amazeui.min.css" />
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="css/light/normalize.css">
<script src="js/inputshine/modernizr.js" type="text/javascript"></script>
<script src="js/prefixfree.min.js"></script>
<style>


.logo-img {
	width: 50px;
	height: 50px;
	margin: 3px;
	border-radius: 25%;
	overflow: hidden
}

.logo-img>img {
	width: 50px;
	height: 50px;
}
.am-topbar-right{
    float: right;
}
.content-mainview{

}


#stars {
  width: 1px;
  height: 1px;
  background: transparent;
  box-shadow: 1407px 511px #FFF , 1611px 119px #FFF , 1686px 956px #FFF , 1163px 1929px #FFF , 912px 1242px #FFF , 490px 469px #FFF , 869px 425px #FFF , 1447px 891px #FFF , 422px 1960px #FFF , 517px 1995px #FFF , 738px 171px #FFF , 1328px 1668px #FFF , 874px 1490px #FFF , 83px 81px #FFF , 632px 98px #FFF , 1518px 1764px #FFF , 636px 596px #FFF , 1178px 131px #FFF , 278px 1179px #FFF , 1898px 1951px #FFF , 1787px 326px #FFF , 186px 1588px #FFF , 552px 1942px #FFF , 1929px 1300px #FFF , 802px 681px #FFF , 430px 1711px #FFF , 1192px 308px #FFF , 123px 1604px #FFF , 880px 169px #FFF , 1400px 632px #FFF , 500px 1165px #FFF , 288px 1208px #FFF , 319px 1419px #FFF , 1170px 980px #FFF , 1608px 784px #FFF , 1735px 1276px #FFF , 966px 1534px #FFF , 654px 783px #FFF , 1366px 964px #FFF , 1213px 60px #FFF , 302px 1509px #FFF , 845px 714px #FFF , 524px 323px #FFF , 1538px 1399px #FFF , 394px 619px #FFF , 680px 26px #FFF , 353px 776px #FFF , 1826px 1450px #FFF , 1909px 1452px #FFF , 1014px 1315px #FFF , 1883px 1474px #FFF , 766px 1742px #FFF , 1693px 658px #FFF , 1186px 302px #FFF , 376px 1575px #FFF , 712px 1739px #FFF , 1627px 299px #FFF , 482px 224px #FFF , 1379px 510px #FFF , 1543px 1602px #FFF , 45px 606px #FFF , 827px 1336px #FFF , 224px 1939px #FFF , 1098px 1342px #FFF , 813px 1553px #FFF , 825px 419px #FFF , 519px 894px #FFF , 1406px 797px #FFF , 1341px 274px #FFF , 1787px 903px #FFF , 1701px 1483px #FFF , 1108px 232px #FFF , 1599px 1409px #FFF , 659px 870px #FFF , 1538px 335px #FFF , 632px 1855px #FFF , 154px 1026px #FFF , 1722px 979px #FFF , 1339px 509px #FFF , 1833px 460px #FFF , 315px 65px #FFF , 496px 1927px #FFF , 1314px 427px #FFF , 344px 1046px #FFF , 1658px 724px #FFF , 1899px 264px #FFF , 1200px 1305px #FFF , 1562px 339px #FFF , 159px 766px #FFF , 1639px 1966px #FFF , 459px 1898px #FFF , 944px 763px #FFF , 1174px 1056px #FFF , 1825px 790px #FFF , 906px 1526px #FFF , 1537px 1303px #FFF , 79px 1105px #FFF , 1318px 672px #FFF , 1232px 61px #FFF , 709px 1078px #FFF , 1010px 1810px #FFF , 777px 1160px #FFF , 1598px 1428px #FFF , 815px 684px #FFF , 1003px 943px #FFF , 1876px 1003px #FFF , 1025px 1529px #FFF , 66px 549px #FFF , 514px 457px #FFF , 262px 1005px #FFF , 812px 1705px #FFF , 1163px 1087px #FFF , 165px 45px #FFF , 677px 1462px #FFF , 580px 1675px #FFF , 1848px 1384px #FFF , 449px 862px #FFF , 1629px 1979px #FFF , 667px 135px #FFF , 240px 53px #FFF , 1919px 1832px #FFF , 696px 1384px #FFF , 1630px 361px #FFF , 878px 663px #FFF , 1226px 1723px #FFF , 765px 686px #FFF , 576px 1647px #FFF , 97px 1602px #FFF , 1117px 1049px #FFF , 1433px 68px #FFF , 1375px 1991px #FFF , 1755px 990px #FFF , 1483px 801px #FFF , 473px 1802px #FFF , 822px 768px #FFF , 196px 577px #FFF , 516px 504px #FFF , 623px 981px #FFF , 1478px 819px #FFF , 126px 384px #FFF , 584px 1908px #FFF , 1549px 521px #FFF , 1866px 1335px #FFF , 586px 342px #FFF , 1698px 642px #FFF , 136px 188px #FFF , 1613px 520px #FFF , 937px 326px #FFF , 1111px 169px #FFF , 229px 229px #FFF , 1357px 20px #FFF , 725px 1305px #FFF , 23px 1977px #FFF , 426px 1945px #FFF , 1628px 1530px #FFF , 256px 1295px #FFF , 58px 78px #FFF , 409px 1145px #FFF , 1607px 767px #FFF , 212px 144px #FFF , 361px 1890px #FFF , 1827px 1451px #FFF , 1875px 645px #FFF , 571px 853px #FFF , 1302px 301px #FFF , 9px 1344px #FFF , 418px 619px #FFF , 1941px 90px #FFF , 949px 640px #FFF , 179px 1783px #FFF , 1104px 360px #FFF , 1723px 370px #FFF , 1122px 1418px #FFF , 1374px 508px #FFF , 1108px 1089px #FFF , 1440px 1743px #FFF , 462px 1495px #FFF , 1187px 265px #FFF , 567px 74px #FFF , 557px 542px #FFF , 967px 673px #FFF , 825px 1971px #FFF , 988px 1260px #FFF , 710px 1206px #FFF , 538px 1805px #FFF , 137px 861px #FFF , 1922px 1313px #FFF , 481px 470px #FFF , 1224px 316px #FFF , 1979px 239px #FFF , 22px 1155px #FFF , 1640px 186px #FFF , 592px 1709px #FFF , 765px 170px #FFF , 129px 1750px #FFF , 788px 719px #FFF , 181px 1327px #FFF , 433px 1455px #FFF , 141px 450px #FFF , 1287px 1027px #FFF , 1278px 1462px #FFF , 688px 1526px #FFF , 463px 1604px #FFF , 1232px 297px #FFF , 920px 1227px #FFF , 1571px 1765px #FFF , 1482px 1316px #FFF , 759px 1463px #FFF , 950px 1166px #FFF , 1532px 1588px #FFF , 608px 267px #FFF , 1862px 1943px #FFF , 805px 717px #FFF , 1803px 1319px #FFF , 1821px 683px #FFF , 995px 1958px #FFF , 484px 932px #FFF , 366px 901px #FFF , 451px 1563px #FFF , 1704px 1471px #FFF , 1379px 44px #FFF , 1778px 472px #FFF , 419px 1806px #FFF , 1545px 222px #FFF , 1563px 777px #FFF , 39px 964px #FFF , 1620px 24px #FFF , 1151px 320px #FFF , 1940px 1426px #FFF , 1555px 1538px #FFF , 1747px 488px #FFF , 1348px 300px #FFF , 990px 538px #FFF , 780px 361px #FFF , 988px 971px #FFF , 1973px 1534px #FFF , 1542px 1829px #FFF , 1557px 216px #FFF , 1404px 641px #FFF , 47px 877px #FFF , 65px 1738px #FFF , 1895px 1798px #FFF , 56px 591px #FFF , 536px 906px #FFF , 568px 74px #FFF , 433px 462px #FFF , 727px 295px #FFF , 876px 1878px #FFF , 1891px 1946px #FFF , 1451px 493px #FFF , 1569px 226px #FFF , 879px 1351px #FFF , 1529px 43px #FFF , 33px 74px #FFF , 1516px 1924px #FFF , 878px 323px #FFF , 455px 1122px #FFF , 1943px 526px #FFF , 1456px 1060px #FFF , 1631px 979px #FFF , 1819px 1324px #FFF , 1660px 1192px #FFF , 1867px 1714px #FFF , 1928px 1940px #FFF , 1618px 744px #FFF , 979px 357px #FFF , 98px 1645px #FFF , 1898px 1207px #FFF , 1134px 16px #FFF , 1313px 1018px #FFF , 717px 812px #FFF , 1503px 234px #FFF , 1612px 188px #FFF , 29px 459px #FFF , 414px 1487px #FFF , 1223px 1730px #FFF , 1643px 1188px #FFF , 424px 767px #FFF , 1692px 1591px #FFF , 1265px 367px #FFF , 54px 832px #FFF , 410px 804px #FFF , 1397px 1242px #FFF , 549px 1484px #FFF , 721px 1088px #FFF , 472px 1240px #FFF , 1927px 514px #FFF , 1303px 1310px #FFF , 71px 1276px #FFF , 829px 1332px #FFF , 84px 1920px #FFF , 1088px 375px #FFF , 1659px 736px #FFF , 967px 294px #FFF , 651px 92px #FFF , 1572px 143px #FFF , 1680px 770px #FFF , 1873px 1289px #FFF , 1983px 821px #FFF , 448px 1090px #FFF , 890px 1332px #FFF , 836px 867px #FFF , 1867px 1213px #FFF , 1874px 1574px #FFF , 750px 1063px #FFF , 1297px 1971px #FFF , 1274px 1015px #FFF , 1628px 933px #FFF , 309px 1386px #FFF , 299px 1621px #FFF , 1973px 526px #FFF , 196px 1416px #FFF , 778px 715px #FFF , 1993px 1294px #FFF , 381px 435px #FFF , 1405px 681px #FFF , 1759px 1077px #FFF , 1764px 1748px #FFF , 168px 470px #FFF , 978px 781px #FFF , 110px 1666px #FFF , 835px 747px #FFF , 112px 95px #FFF , 604px 712px #FFF , 1121px 1752px #FFF , 393px 1782px #FFF , 1869px 830px #FFF , 1303px 348px #FFF , 427px 1546px #FFF , 761px 718px #FFF , 946px 674px #FFF , 832px 964px #FFF , 1607px 2000px #FFF , 1624px 1296px #FFF , 1093px 735px #FFF , 1865px 608px #FFF , 933px 1278px #FFF , 1402px 547px #FFF , 1865px 1211px #FFF , 109px 72px #FFF , 249px 1482px #FFF , 586px 1933px #FFF , 911px 1336px #FFF , 697px 853px #FFF , 987px 1797px #FFF , 1371px 933px #FFF , 492px 1896px #FFF , 998px 1866px #FFF , 518px 31px #FFF , 1873px 372px #FFF , 1025px 1308px #FFF , 1478px 965px #FFF , 1934px 934px #FFF , 1048px 1262px #FFF , 1839px 40px #FFF , 1399px 732px #FFF , 735px 416px #FFF , 621px 394px #FFF , 788px 1802px #FFF , 1918px 307px #FFF , 432px 1845px #FFF , 616px 481px #FFF , 921px 798px #FFF , 354px 597px #FFF , 1622px 214px #FFF , 1349px 1983px #FFF , 1033px 1622px #FFF , 1198px 407px #FFF , 1239px 1449px #FFF , 1278px 1978px #FFF , 426px 1264px #FFF , 507px 1341px #FFF , 1956px 818px #FFF , 1041px 277px #FFF , 1371px 639px #FFF , 1224px 419px #FFF , 211px 1106px #FFF , 847px 656px #FFF , 534px 1891px #FFF , 1289px 823px #FFF , 906px 482px #FFF , 347px 1837px #FFF , 1246px 1462px #FFF , 915px 1858px #FFF , 559px 1320px #FFF , 77px 1555px #FFF , 845px 1743px #FFF , 313px 1414px #FFF , 188px 252px #FFF , 509px 637px #FFF , 374px 142px #FFF , 1397px 474px #FFF , 458px 1197px #FFF , 292px 619px #FFF , 1749px 14px #FFF , 1638px 24px #FFF , 563px 1752px #FFF , 1940px 1065px #FFF , 1145px 1030px #FFF , 894px 1470px #FFF , 444px 32px #FFF , 1341px 1136px #FFF , 1941px 412px #FFF , 1328px 785px #FFF , 161px 1740px #FFF , 948px 829px #FFF , 933px 823px #FFF , 1709px 507px #FFF , 1366px 1821px #FFF , 720px 731px #FFF , 162px 682px #FFF , 1684px 882px #FFF , 134px 497px #FFF , 1659px 1701px #FFF , 1186px 446px #FFF , 911px 1435px #FFF , 1814px 1028px #FFF , 1234px 1520px #FFF , 1186px 23px #FFF , 318px 87px #FFF , 1179px 837px #FFF , 1071px 46px #FFF , 1125px 1862px #FFF , 94px 261px #FFF , 1574px 282px #FFF , 1039px 815px #FFF , 1776px 1472px #FFF , 867px 473px #FFF , 901px 215px #FFF , 862px 630px #FFF , 1480px 1673px #FFF , 411px 1896px #FFF , 1335px 944px #FFF , 148px 1235px #FFF , 57px 140px #FFF , 447px 651px #FFF , 1414px 1651px #FFF , 209px 1770px #FFF , 1800px 1590px #FFF , 1304px 1px #FFF , 279px 771px #FFF , 1770px 1398px #FFF , 724px 1201px #FFF , 245px 1145px #FFF , 172px 1951px #FFF , 284px 236px #FFF , 1905px 1307px #FFF , 1948px 574px #FFF , 283px 669px #FFF , 247px 384px #FFF , 224px 619px #FFF , 128px 772px #FFF , 1698px 1405px #FFF , 830px 505px #FFF , 1938px 397px #FFF , 1772px 1001px #FFF , 1454px 808px #FFF , 304px 561px #FFF , 1321px 966px #FFF , 735px 1368px #FFF , 894px 345px #FFF , 1217px 1997px #FFF , 892px 1342px #FFF , 353px 379px #FFF , 1382px 1156px #FFF , 164px 1239px #FFF , 1268px 1859px #FFF , 1385px 1721px #FFF , 16px 283px #FFF , 1819px 200px #FFF , 660px 1111px #FFF , 1679px 1728px #FFF , 463px 596px #FFF , 217px 1834px #FFF , 1879px 538px #FFF , 304px 906px #FFF , 1327px 1347px #FFF , 1226px 1579px #FFF , 1786px 1616px #FFF , 1234px 1982px #FFF , 1868px 1862px #FFF , 814px 948px #FFF , 178px 1837px #FFF , 571px 1701px #FFF , 106px 566px #FFF , 270px 925px #FFF , 1417px 248px #FFF , 609px 1551px #FFF , 992px 1825px #FFF , 1515px 1999px #FFF , 1167px 914px #FFF , 1698px 490px #FFF , 189px 1463px #FFF , 928px 612px #FFF , 1714px 803px #FFF , 535px 402px #FFF , 1000px 379px #FFF , 1610px 574px #FFF , 1882px 1155px #FFF , 1425px 1514px #FFF , 417px 1987px #FFF , 1681px 1059px #FFF , 841px 762px #FFF , 1886px 1098px #FFF , 1785px 236px #FFF , 1950px 950px #FFF , 444px 1937px #FFF , 1364px 540px #FFF , 1971px 225px #FFF , 1624px 868px #FFF , 869px 640px #FFF , 1637px 559px #FFF , 20px 823px #FFF , 409px 177px #FFF , 1804px 1626px #FFF , 388px 527px #FFF , 1385px 1734px #FFF , 988px 1310px #FFF , 443px 599px #FFF , 1780px 434px #FFF , 654px 419px #FFF , 268px 1424px #FFF , 1971px 40px #FFF , 360px 1834px #FFF , 875px 1930px #FFF , 1866px 1885px #FFF , 453px 1670px #FFF , 1696px 1337px #FFF , 604px 1887px #FFF , 1405px 769px #FFF , 1546px 897px #FFF , 595px 1975px #FFF , 32px 1765px #FFF , 896px 1150px #FFF , 1818px 95px #FFF , 444px 49px #FFF , 589px 1796px #FFF , 764px 1965px #FFF , 920px 1803px #FFF , 403px 1997px #FFF , 833px 1282px #FFF , 1127px 1770px #FFF , 1810px 77px #FFF , 1214px 1102px #FFF , 364px 401px #FFF , 1139px 1191px #FFF , 916px 1907px #FFF , 870px 290px #FFF , 688px 678px #FFF , 1523px 34px #FFF , 1265px 1082px #FFF , 1394px 1080px #FFF , 1787px 1738px #FFF , 1682px 755px #FFF , 1955px 832px #FFF , 546px 1577px #FFF , 1062px 1561px #FFF , 344px 826px #FFF , 1442px 782px #FFF , 467px 1477px #FFF , 879px 1439px #FFF , 1672px 268px #FFF , 1317px 1355px #FFF , 1980px 1965px #FFF , 688px 1465px #FFF , 1131px 872px #FFF , 1301px 1656px #FFF , 974px 583px #FFF , 1613px 1467px #FFF , 1976px 1995px #FFF , 1377px 760px #FFF , 1367px 387px #FFF , 1880px 191px #FFF , 711px 876px #FFF , 539px 152px #FFF , 545px 1809px #FFF , 920px 970px #FFF , 1154px 1355px #FFF , 1968px 94px #FFF , 1703px 490px #FFF , 380px 146px #FFF , 1561px 785px #FFF , 1930px 1385px #FFF , 519px 1091px #FFF , 269px 570px #FFF , 109px 1326px #FFF , 1476px 969px #FFF , 1999px 1885px #FFF , 341px 1238px #FFF , 1105px 1076px #FFF , 596px 88px #FFF , 937px 492px #FFF , 1339px 1673px #FFF , 1967px 762px #FFF , 65px 952px #FFF , 111px 93px #FFF , 1011px 1684px #FFF , 377px 1430px #FFF , 1011px 386px #FFF , 1162px 421px #FFF , 196px 617px #FFF , 1407px 1141px #FFF , 1562px 572px #FFF , 316px 690px #FFF , 1600px 1980px #FFF , 1545px 1254px #FFF , 680px 1120px #FFF , 575px 1284px #FFF , 179px 1470px #FFF , 1496px 1506px #FFF , 977px 1376px #FFF , 1282px 708px #FFF , 408px 1427px #FFF , 1173px 1597px #FFF , 1120px 1755px #FFF , 974px 520px #FFF , 979px 384px #FFF , 622px 1116px #FFF , 1307px 866px #FFF , 1188px 1596px #FFF , 858px 1947px #FFF , 861px 1373px #FFF , 857px 43px #FFF , 1878px 499px #FFF , 1297px 535px #FFF , 870px 1286px #FFF , 1452px 448px #FFF , 906px 72px #FFF , 1450px 872px #FFF , 1607px 1755px #FFF , 1071px 1959px #FFF , 976px 879px #FFF , 1435px 284px #FFF , 1601px 496px #FFF , 671px 1713px #FFF , 356px 1148px #FFF , 837px 867px #FFF , 246px 858px #FFF , 1031px 1594px #FFF , 571px 214px #FFF , 1012px 1329px #FFF , 1566px 1142px #FFF , 219px 1376px #FFF , 1580px 1454px #FFF , 690px 1037px #FFF , 1940px 756px #FFF , 1755px 850px #FFF , 1037px 363px #FFF , 25px 515px #FFF , 806px 1571px #FFF , 1266px 1398px #FFF , 695px 791px #FFF , 1838px 950px #FFF , 1578px 27px #FFF , 1692px 1581px #FFF , 1817px 1040px #FFF , 1781px 238px #FFF , 1052px 895px #FFF , 398px 440px #FFF , 1643px 325px #FFF , 79px 848px #FFF , 1295px 326px #FFF , 293px 81px #FFF , 1202px 1580px #FFF , 1441px 100px #FFF , 1295px 1465px #FFF , 1132px 1275px #FFF , 774px 704px #FFF , 1109px 1546px #FFF , 557px 1390px #FFF , 1253px 1224px #FFF , 1063px 1618px #FFF , 1793px 440px #FFF , 890px 1988px #FFF , 814px 424px #FFF , 1390px 1280px #FFF , 1127px 907px #FFF , 1044px 1368px #FFF , 1317px 876px #FFF , 762px 638px #FFF , 965px 747px #FFF , 755px 1945px #FFF , 706px 414px #FFF , 1842px 1673px #FFF , 1158px 1336px #FFF , 989px 1955px #FFF , 1857px 89px #FFF , 1659px 343px #FFF , 509px 1385px #FFF , 1620px 758px #FFF , 1958px 1064px #FFF , 178px 341px #FFF , 1500px 808px #FFF , 20px 1646px #FFF , 1572px 870px #FFF , 1821px 1377px #FFF , 328px 1965px #FFF , 903px 616px #FFF , 1731px 1599px #FFF , 267px 856px #FFF;
  animation: animStar 50s linear infinite;
}
#stars:after {
  content: " ";
  position: absolute;
  top: 2000px;
  width: 1px;
  height: 1px;
  background: transparent;
  box-shadow: 1407px 511px #FFF , 1611px 119px #FFF , 1686px 956px #FFF , 1163px 1929px #FFF , 912px 1242px #FFF , 490px 469px #FFF , 869px 425px #FFF , 1447px 891px #FFF , 422px 1960px #FFF , 517px 1995px #FFF , 738px 171px #FFF , 1328px 1668px #FFF , 874px 1490px #FFF , 83px 81px #FFF , 632px 98px #FFF , 1518px 1764px #FFF , 636px 596px #FFF , 1178px 131px #FFF , 278px 1179px #FFF , 1898px 1951px #FFF , 1787px 326px #FFF , 186px 1588px #FFF , 552px 1942px #FFF , 1929px 1300px #FFF , 802px 681px #FFF , 430px 1711px #FFF , 1192px 308px #FFF , 123px 1604px #FFF , 880px 169px #FFF , 1400px 632px #FFF , 500px 1165px #FFF , 288px 1208px #FFF , 319px 1419px #FFF , 1170px 980px #FFF , 1608px 784px #FFF , 1735px 1276px #FFF , 966px 1534px #FFF , 654px 783px #FFF , 1366px 964px #FFF , 1213px 60px #FFF , 302px 1509px #FFF , 845px 714px #FFF , 524px 323px #FFF , 1538px 1399px #FFF , 394px 619px #FFF , 680px 26px #FFF , 353px 776px #FFF , 1826px 1450px #FFF , 1909px 1452px #FFF , 1014px 1315px #FFF , 1883px 1474px #FFF , 766px 1742px #FFF , 1693px 658px #FFF , 1186px 302px #FFF , 376px 1575px #FFF , 712px 1739px #FFF , 1627px 299px #FFF , 482px 224px #FFF , 1379px 510px #FFF , 1543px 1602px #FFF , 45px 606px #FFF , 827px 1336px #FFF , 224px 1939px #FFF , 1098px 1342px #FFF , 813px 1553px #FFF , 825px 419px #FFF , 519px 894px #FFF , 1406px 797px #FFF , 1341px 274px #FFF , 1787px 903px #FFF , 1701px 1483px #FFF , 1108px 232px #FFF , 1599px 1409px #FFF , 659px 870px #FFF , 1538px 335px #FFF , 632px 1855px #FFF , 154px 1026px #FFF , 1722px 979px #FFF , 1339px 509px #FFF , 1833px 460px #FFF , 315px 65px #FFF , 496px 1927px #FFF , 1314px 427px #FFF , 344px 1046px #FFF , 1658px 724px #FFF , 1899px 264px #FFF , 1200px 1305px #FFF , 1562px 339px #FFF , 159px 766px #FFF , 1639px 1966px #FFF , 459px 1898px #FFF , 944px 763px #FFF , 1174px 1056px #FFF , 1825px 790px #FFF , 906px 1526px #FFF , 1537px 1303px #FFF , 79px 1105px #FFF , 1318px 672px #FFF , 1232px 61px #FFF , 709px 1078px #FFF , 1010px 1810px #FFF , 777px 1160px #FFF , 1598px 1428px #FFF , 815px 684px #FFF , 1003px 943px #FFF , 1876px 1003px #FFF , 1025px 1529px #FFF , 66px 549px #FFF , 514px 457px #FFF , 262px 1005px #FFF , 812px 1705px #FFF , 1163px 1087px #FFF , 165px 45px #FFF , 677px 1462px #FFF , 580px 1675px #FFF , 1848px 1384px #FFF , 449px 862px #FFF , 1629px 1979px #FFF , 667px 135px #FFF , 240px 53px #FFF , 1919px 1832px #FFF , 696px 1384px #FFF , 1630px 361px #FFF , 878px 663px #FFF , 1226px 1723px #FFF , 765px 686px #FFF , 576px 1647px #FFF , 97px 1602px #FFF , 1117px 1049px #FFF , 1433px 68px #FFF , 1375px 1991px #FFF , 1755px 990px #FFF , 1483px 801px #FFF , 473px 1802px #FFF , 822px 768px #FFF , 196px 577px #FFF , 516px 504px #FFF , 623px 981px #FFF , 1478px 819px #FFF , 126px 384px #FFF , 584px 1908px #FFF , 1549px 521px #FFF , 1866px 1335px #FFF , 586px 342px #FFF , 1698px 642px #FFF , 136px 188px #FFF , 1613px 520px #FFF , 937px 326px #FFF , 1111px 169px #FFF , 229px 229px #FFF , 1357px 20px #FFF , 725px 1305px #FFF , 23px 1977px #FFF , 426px 1945px #FFF , 1628px 1530px #FFF , 256px 1295px #FFF , 58px 78px #FFF , 409px 1145px #FFF , 1607px 767px #FFF , 212px 144px #FFF , 361px 1890px #FFF , 1827px 1451px #FFF , 1875px 645px #FFF , 571px 853px #FFF , 1302px 301px #FFF , 9px 1344px #FFF , 418px 619px #FFF , 1941px 90px #FFF , 949px 640px #FFF , 179px 1783px #FFF , 1104px 360px #FFF , 1723px 370px #FFF , 1122px 1418px #FFF , 1374px 508px #FFF , 1108px 1089px #FFF , 1440px 1743px #FFF , 462px 1495px #FFF , 1187px 265px #FFF , 567px 74px #FFF , 557px 542px #FFF , 967px 673px #FFF , 825px 1971px #FFF , 988px 1260px #FFF , 710px 1206px #FFF , 538px 1805px #FFF , 137px 861px #FFF , 1922px 1313px #FFF , 481px 470px #FFF , 1224px 316px #FFF , 1979px 239px #FFF , 22px 1155px #FFF , 1640px 186px #FFF , 592px 1709px #FFF , 765px 170px #FFF , 129px 1750px #FFF , 788px 719px #FFF , 181px 1327px #FFF , 433px 1455px #FFF , 141px 450px #FFF , 1287px 1027px #FFF , 1278px 1462px #FFF , 688px 1526px #FFF , 463px 1604px #FFF , 1232px 297px #FFF , 920px 1227px #FFF , 1571px 1765px #FFF , 1482px 1316px #FFF , 759px 1463px #FFF , 950px 1166px #FFF , 1532px 1588px #FFF , 608px 267px #FFF , 1862px 1943px #FFF , 805px 717px #FFF , 1803px 1319px #FFF , 1821px 683px #FFF , 995px 1958px #FFF , 484px 932px #FFF , 366px 901px #FFF , 451px 1563px #FFF , 1704px 1471px #FFF , 1379px 44px #FFF , 1778px 472px #FFF , 419px 1806px #FFF , 1545px 222px #FFF , 1563px 777px #FFF , 39px 964px #FFF , 1620px 24px #FFF , 1151px 320px #FFF , 1940px 1426px #FFF , 1555px 1538px #FFF , 1747px 488px #FFF , 1348px 300px #FFF , 990px 538px #FFF , 780px 361px #FFF , 988px 971px #FFF , 1973px 1534px #FFF , 1542px 1829px #FFF , 1557px 216px #FFF , 1404px 641px #FFF , 47px 877px #FFF , 65px 1738px #FFF , 1895px 1798px #FFF , 56px 591px #FFF , 536px 906px #FFF , 568px 74px #FFF , 433px 462px #FFF , 727px 295px #FFF , 876px 1878px #FFF , 1891px 1946px #FFF , 1451px 493px #FFF , 1569px 226px #FFF , 879px 1351px #FFF , 1529px 43px #FFF , 33px 74px #FFF , 1516px 1924px #FFF , 878px 323px #FFF , 455px 1122px #FFF , 1943px 526px #FFF , 1456px 1060px #FFF , 1631px 979px #FFF , 1819px 1324px #FFF , 1660px 1192px #FFF , 1867px 1714px #FFF , 1928px 1940px #FFF , 1618px 744px #FFF , 979px 357px #FFF , 98px 1645px #FFF , 1898px 1207px #FFF , 1134px 16px #FFF , 1313px 1018px #FFF , 717px 812px #FFF , 1503px 234px #FFF , 1612px 188px #FFF , 29px 459px #FFF , 414px 1487px #FFF , 1223px 1730px #FFF , 1643px 1188px #FFF , 424px 767px #FFF , 1692px 1591px #FFF , 1265px 367px #FFF , 54px 832px #FFF , 410px 804px #FFF , 1397px 1242px #FFF , 549px 1484px #FFF , 721px 1088px #FFF , 472px 1240px #FFF , 1927px 514px #FFF , 1303px 1310px #FFF , 71px 1276px #FFF , 829px 1332px #FFF , 84px 1920px #FFF , 1088px 375px #FFF , 1659px 736px #FFF , 967px 294px #FFF , 651px 92px #FFF , 1572px 143px #FFF , 1680px 770px #FFF , 1873px 1289px #FFF , 1983px 821px #FFF , 448px 1090px #FFF , 890px 1332px #FFF , 836px 867px #FFF , 1867px 1213px #FFF , 1874px 1574px #FFF , 750px 1063px #FFF , 1297px 1971px #FFF , 1274px 1015px #FFF , 1628px 933px #FFF , 309px 1386px #FFF , 299px 1621px #FFF , 1973px 526px #FFF , 196px 1416px #FFF , 778px 715px #FFF , 1993px 1294px #FFF , 381px 435px #FFF , 1405px 681px #FFF , 1759px 1077px #FFF , 1764px 1748px #FFF , 168px 470px #FFF , 978px 781px #FFF , 110px 1666px #FFF , 835px 747px #FFF , 112px 95px #FFF , 604px 712px #FFF , 1121px 1752px #FFF , 393px 1782px #FFF , 1869px 830px #FFF , 1303px 348px #FFF , 427px 1546px #FFF , 761px 718px #FFF , 946px 674px #FFF , 832px 964px #FFF , 1607px 2000px #FFF , 1624px 1296px #FFF , 1093px 735px #FFF , 1865px 608px #FFF , 933px 1278px #FFF , 1402px 547px #FFF , 1865px 1211px #FFF , 109px 72px #FFF , 249px 1482px #FFF , 586px 1933px #FFF , 911px 1336px #FFF , 697px 853px #FFF , 987px 1797px #FFF , 1371px 933px #FFF , 492px 1896px #FFF , 998px 1866px #FFF , 518px 31px #FFF , 1873px 372px #FFF , 1025px 1308px #FFF , 1478px 965px #FFF , 1934px 934px #FFF , 1048px 1262px #FFF , 1839px 40px #FFF , 1399px 732px #FFF , 735px 416px #FFF , 621px 394px #FFF , 788px 1802px #FFF , 1918px 307px #FFF , 432px 1845px #FFF , 616px 481px #FFF , 921px 798px #FFF , 354px 597px #FFF , 1622px 214px #FFF , 1349px 1983px #FFF , 1033px 1622px #FFF , 1198px 407px #FFF , 1239px 1449px #FFF , 1278px 1978px #FFF , 426px 1264px #FFF , 507px 1341px #FFF , 1956px 818px #FFF , 1041px 277px #FFF , 1371px 639px #FFF , 1224px 419px #FFF , 211px 1106px #FFF , 847px 656px #FFF , 534px 1891px #FFF , 1289px 823px #FFF , 906px 482px #FFF , 347px 1837px #FFF , 1246px 1462px #FFF , 915px 1858px #FFF , 559px 1320px #FFF , 77px 1555px #FFF , 845px 1743px #FFF , 313px 1414px #FFF , 188px 252px #FFF , 509px 637px #FFF , 374px 142px #FFF , 1397px 474px #FFF , 458px 1197px #FFF , 292px 619px #FFF , 1749px 14px #FFF , 1638px 24px #FFF , 563px 1752px #FFF , 1940px 1065px #FFF , 1145px 1030px #FFF , 894px 1470px #FFF , 444px 32px #FFF , 1341px 1136px #FFF , 1941px 412px #FFF , 1328px 785px #FFF , 161px 1740px #FFF , 948px 829px #FFF , 933px 823px #FFF , 1709px 507px #FFF , 1366px 1821px #FFF , 720px 731px #FFF , 162px 682px #FFF , 1684px 882px #FFF , 134px 497px #FFF , 1659px 1701px #FFF , 1186px 446px #FFF , 911px 1435px #FFF , 1814px 1028px #FFF , 1234px 1520px #FFF , 1186px 23px #FFF , 318px 87px #FFF , 1179px 837px #FFF , 1071px 46px #FFF , 1125px 1862px #FFF , 94px 261px #FFF , 1574px 282px #FFF , 1039px 815px #FFF , 1776px 1472px #FFF , 867px 473px #FFF , 901px 215px #FFF , 862px 630px #FFF , 1480px 1673px #FFF , 411px 1896px #FFF , 1335px 944px #FFF , 148px 1235px #FFF , 57px 140px #FFF , 447px 651px #FFF , 1414px 1651px #FFF , 209px 1770px #FFF , 1800px 1590px #FFF , 1304px 1px #FFF , 279px 771px #FFF , 1770px 1398px #FFF , 724px 1201px #FFF , 245px 1145px #FFF , 172px 1951px #FFF , 284px 236px #FFF , 1905px 1307px #FFF , 1948px 574px #FFF , 283px 669px #FFF , 247px 384px #FFF , 224px 619px #FFF , 128px 772px #FFF , 1698px 1405px #FFF , 830px 505px #FFF , 1938px 397px #FFF , 1772px 1001px #FFF , 1454px 808px #FFF , 304px 561px #FFF , 1321px 966px #FFF , 735px 1368px #FFF , 894px 345px #FFF , 1217px 1997px #FFF , 892px 1342px #FFF , 353px 379px #FFF , 1382px 1156px #FFF , 164px 1239px #FFF , 1268px 1859px #FFF , 1385px 1721px #FFF , 16px 283px #FFF , 1819px 200px #FFF , 660px 1111px #FFF , 1679px 1728px #FFF , 463px 596px #FFF , 217px 1834px #FFF , 1879px 538px #FFF , 304px 906px #FFF , 1327px 1347px #FFF , 1226px 1579px #FFF , 1786px 1616px #FFF , 1234px 1982px #FFF , 1868px 1862px #FFF , 814px 948px #FFF , 178px 1837px #FFF , 571px 1701px #FFF , 106px 566px #FFF , 270px 925px #FFF , 1417px 248px #FFF , 609px 1551px #FFF , 992px 1825px #FFF , 1515px 1999px #FFF , 1167px 914px #FFF , 1698px 490px #FFF , 189px 1463px #FFF , 928px 612px #FFF , 1714px 803px #FFF , 535px 402px #FFF , 1000px 379px #FFF , 1610px 574px #FFF , 1882px 1155px #FFF , 1425px 1514px #FFF , 417px 1987px #FFF , 1681px 1059px #FFF , 841px 762px #FFF , 1886px 1098px #FFF , 1785px 236px #FFF , 1950px 950px #FFF , 444px 1937px #FFF , 1364px 540px #FFF , 1971px 225px #FFF , 1624px 868px #FFF , 869px 640px #FFF , 1637px 559px #FFF , 20px 823px #FFF , 409px 177px #FFF , 1804px 1626px #FFF , 388px 527px #FFF , 1385px 1734px #FFF , 988px 1310px #FFF , 443px 599px #FFF , 1780px 434px #FFF , 654px 419px #FFF , 268px 1424px #FFF , 1971px 40px #FFF , 360px 1834px #FFF , 875px 1930px #FFF , 1866px 1885px #FFF , 453px 1670px #FFF , 1696px 1337px #FFF , 604px 1887px #FFF , 1405px 769px #FFF , 1546px 897px #FFF , 595px 1975px #FFF , 32px 1765px #FFF , 896px 1150px #FFF , 1818px 95px #FFF , 444px 49px #FFF , 589px 1796px #FFF , 764px 1965px #FFF , 920px 1803px #FFF , 403px 1997px #FFF , 833px 1282px #FFF , 1127px 1770px #FFF , 1810px 77px #FFF , 1214px 1102px #FFF , 364px 401px #FFF , 1139px 1191px #FFF , 916px 1907px #FFF , 870px 290px #FFF , 688px 678px #FFF , 1523px 34px #FFF , 1265px 1082px #FFF , 1394px 1080px #FFF , 1787px 1738px #FFF , 1682px 755px #FFF , 1955px 832px #FFF , 546px 1577px #FFF , 1062px 1561px #FFF , 344px 826px #FFF , 1442px 782px #FFF , 467px 1477px #FFF , 879px 1439px #FFF , 1672px 268px #FFF , 1317px 1355px #FFF , 1980px 1965px #FFF , 688px 1465px #FFF , 1131px 872px #FFF , 1301px 1656px #FFF , 974px 583px #FFF , 1613px 1467px #FFF , 1976px 1995px #FFF , 1377px 760px #FFF , 1367px 387px #FFF , 1880px 191px #FFF , 711px 876px #FFF , 539px 152px #FFF , 545px 1809px #FFF , 920px 970px #FFF , 1154px 1355px #FFF , 1968px 94px #FFF , 1703px 490px #FFF , 380px 146px #FFF , 1561px 785px #FFF , 1930px 1385px #FFF , 519px 1091px #FFF , 269px 570px #FFF , 109px 1326px #FFF , 1476px 969px #FFF , 1999px 1885px #FFF , 341px 1238px #FFF , 1105px 1076px #FFF , 596px 88px #FFF , 937px 492px #FFF , 1339px 1673px #FFF , 1967px 762px #FFF , 65px 952px #FFF , 111px 93px #FFF , 1011px 1684px #FFF , 377px 1430px #FFF , 1011px 386px #FFF , 1162px 421px #FFF , 196px 617px #FFF , 1407px 1141px #FFF , 1562px 572px #FFF , 316px 690px #FFF , 1600px 1980px #FFF , 1545px 1254px #FFF , 680px 1120px #FFF , 575px 1284px #FFF , 179px 1470px #FFF , 1496px 1506px #FFF , 977px 1376px #FFF , 1282px 708px #FFF , 408px 1427px #FFF , 1173px 1597px #FFF , 1120px 1755px #FFF , 974px 520px #FFF , 979px 384px #FFF , 622px 1116px #FFF , 1307px 866px #FFF , 1188px 1596px #FFF , 858px 1947px #FFF , 861px 1373px #FFF , 857px 43px #FFF , 1878px 499px #FFF , 1297px 535px #FFF , 870px 1286px #FFF , 1452px 448px #FFF , 906px 72px #FFF , 1450px 872px #FFF , 1607px 1755px #FFF , 1071px 1959px #FFF , 976px 879px #FFF , 1435px 284px #FFF , 1601px 496px #FFF , 671px 1713px #FFF , 356px 1148px #FFF , 837px 867px #FFF , 246px 858px #FFF , 1031px 1594px #FFF , 571px 214px #FFF , 1012px 1329px #FFF , 1566px 1142px #FFF , 219px 1376px #FFF , 1580px 1454px #FFF , 690px 1037px #FFF , 1940px 756px #FFF , 1755px 850px #FFF , 1037px 363px #FFF , 25px 515px #FFF , 806px 1571px #FFF , 1266px 1398px #FFF , 695px 791px #FFF , 1838px 950px #FFF , 1578px 27px #FFF , 1692px 1581px #FFF , 1817px 1040px #FFF , 1781px 238px #FFF , 1052px 895px #FFF , 398px 440px #FFF , 1643px 325px #FFF , 79px 848px #FFF , 1295px 326px #FFF , 293px 81px #FFF , 1202px 1580px #FFF , 1441px 100px #FFF , 1295px 1465px #FFF , 1132px 1275px #FFF , 774px 704px #FFF , 1109px 1546px #FFF , 557px 1390px #FFF , 1253px 1224px #FFF , 1063px 1618px #FFF , 1793px 440px #FFF , 890px 1988px #FFF , 814px 424px #FFF , 1390px 1280px #FFF , 1127px 907px #FFF , 1044px 1368px #FFF , 1317px 876px #FFF , 762px 638px #FFF , 965px 747px #FFF , 755px 1945px #FFF , 706px 414px #FFF , 1842px 1673px #FFF , 1158px 1336px #FFF , 989px 1955px #FFF , 1857px 89px #FFF , 1659px 343px #FFF , 509px 1385px #FFF , 1620px 758px #FFF , 1958px 1064px #FFF , 178px 341px #FFF , 1500px 808px #FFF , 20px 1646px #FFF , 1572px 870px #FFF , 1821px 1377px #FFF , 328px 1965px #FFF , 903px 616px #FFF , 1731px 1599px #FFF , 267px 856px #FFF;
}

#stars2 {
  width: 2px;
  height: 2px;
  background: transparent;
  box-shadow: 921px 1554px #FFF , 1944px 550px #FFF , 1696px 1632px #FFF , 16px 1899px #FFF , 1894px 130px #FFF , 77px 262px #FFF , 22px 1159px #FFF , 933px 1206px #FFF , 1660px 482px #FFF , 1067px 1154px #FFF , 468px 625px #FFF , 1408px 1687px #FFF , 153px 1200px #FFF , 887px 1966px #FFF , 1260px 514px #FFF , 1167px 1158px #FFF , 790px 553px #FFF , 1103px 758px #FFF , 226px 1028px #FFF , 1340px 1760px #FFF , 1712px 528px #FFF , 114px 1693px #FFF , 185px 572px #FFF , 1566px 1793px #FFF , 317px 1501px #FFF , 846px 530px #FFF , 1585px 1437px #FFF , 1335px 1009px #FFF , 1768px 436px #FFF , 1131px 666px #FFF , 27px 1543px #FFF , 1778px 1861px #FFF , 1496px 30px #FFF , 1359px 1226px #FFF , 416px 135px #FFF , 1675px 673px #FFF , 296px 524px #FFF , 432px 1822px #FFF , 1995px 416px #FFF , 1206px 1846px #FFF , 542px 603px #FFF , 1811px 1083px #FFF , 1125px 1900px #FFF , 4px 1410px #FFF , 665px 1674px #FFF , 982px 365px #FFF , 809px 534px #FFF , 116px 1381px #FFF , 727px 439px #FFF , 1674px 1407px #FFF , 976px 1762px #FFF , 1585px 28px #FFF , 1916px 624px #FFF , 1716px 1118px #FFF , 1022px 177px #FFF , 807px 619px #FFF , 1657px 338px #FFF , 1608px 1259px #FFF , 405px 1890px #FFF , 433px 1978px #FFF , 1457px 1495px #FFF , 175px 989px #FFF , 850px 1044px #FFF , 170px 444px #FFF , 1623px 71px #FFF , 977px 1319px #FFF , 440px 464px #FFF , 51px 1209px #FFF , 783px 1274px #FFF , 1296px 244px #FFF , 1260px 94px #FFF , 652px 905px #FFF , 805px 1307px #FFF , 947px 822px #FFF , 384px 268px #FFF , 1856px 1782px #FFF , 459px 1844px #FFF , 1679px 473px #FFF , 673px 1832px #FFF , 96px 345px #FFF , 1268px 428px #FFF , 788px 1138px #FFF , 1242px 867px #FFF , 652px 831px #FFF , 993px 1706px #FFF , 1337px 64px #FFF , 1092px 624px #FFF , 674px 1344px #FFF , 1036px 405px #FFF , 996px 1371px #FFF , 1906px 1410px #FFF , 1285px 1079px #FFF , 1756px 583px #FFF , 404px 380px #FFF , 1739px 1620px #FFF , 1253px 372px #FFF , 520px 620px #FFF , 1842px 852px #FFF , 490px 387px #FFF , 1251px 143px #FFF , 1814px 537px #FFF , 1405px 623px #FFF , 1236px 1186px #FFF , 1286px 896px #FFF , 1626px 990px #FFF , 31px 1067px #FFF , 1288px 939px #FFF , 763px 338px #FFF , 713px 1515px #FFF , 859px 1621px #FFF , 1720px 1984px #FFF , 796px 1743px #FFF , 1439px 1587px #FFF , 965px 412px #FFF , 775px 1168px #FFF , 1192px 956px #FFF , 368px 1075px #FFF , 1484px 1154px #FFF , 1784px 547px #FFF , 815px 675px #FFF , 1387px 890px #FFF , 1665px 1733px #FFF , 1948px 429px #FFF , 1665px 92px #FFF , 1806px 919px #FFF , 1712px 494px #FFF , 577px 1922px #FFF , 820px 1228px #FFF , 678px 1745px #FFF , 1421px 586px #FFF , 788px 208px #FFF , 380px 250px #FFF , 748px 977px #FFF , 1637px 337px #FFF , 851px 1514px #FFF , 1487px 1410px #FFF , 1776px 710px #FFF , 544px 453px #FFF , 1707px 1932px #FFF , 1121px 1642px #FFF , 1227px 391px #FFF , 583px 833px #FFF , 658px 278px #FFF , 345px 1388px #FFF , 1529px 1419px #FFF , 233px 1008px #FFF , 892px 943px #FFF , 1431px 1091px #FFF , 1524px 316px #FFF , 1547px 192px #FFF , 976px 36px #FFF , 1648px 1053px #FFF , 1833px 1572px #FFF , 1677px 936px #FFF , 589px 1755px #FFF , 978px 1875px #FFF , 1508px 412px #FFF , 1242px 439px #FFF , 1263px 40px #FFF , 1427px 1736px #FFF , 639px 906px #FFF , 1349px 373px #FFF , 1055px 969px #FFF , 602px 95px #FFF , 224px 1805px #FFF , 1129px 837px #FFF , 1110px 1358px #FFF , 1067px 1752px #FFF , 391px 1389px #FFF , 885px 1979px #FFF , 1188px 414px #FFF , 1931px 325px #FFF , 1853px 1918px #FFF , 636px 1313px #FFF , 1236px 1913px #FFF , 1801px 780px #FFF , 633px 529px #FFF , 1500px 33px #FFF , 1387px 1045px #FFF , 832px 1281px #FFF , 1880px 1845px #FFF , 1477px 1096px #FFF , 1457px 698px #FFF , 1658px 1049px #FFF , 1957px 1151px #FFF , 1561px 1593px #FFF , 627px 250px #FFF , 975px 1575px #FFF , 68px 998px #FFF , 951px 85px #FFF , 280px 431px #FFF , 1683px 1745px #FFF , 322px 778px #FFF , 841px 888px #FFF , 1895px 1883px #FFF , 700px 568px #FFF , 1846px 442px #FFF , 91px 1650px #FFF , 970px 917px #FFF , 1585px 452px #FFF;
  animation: animStar 100s linear infinite;
}
#stars2:after {
  content: " ";
  position: absolute;
  top: 2000px;
  width: 2px;
  height: 2px;
  background: transparent;
  box-shadow: 921px 1554px #FFF , 1944px 550px #FFF , 1696px 1632px #FFF , 16px 1899px #FFF , 1894px 130px #FFF , 77px 262px #FFF , 22px 1159px #FFF , 933px 1206px #FFF , 1660px 482px #FFF , 1067px 1154px #FFF , 468px 625px #FFF , 1408px 1687px #FFF , 153px 1200px #FFF , 887px 1966px #FFF , 1260px 514px #FFF , 1167px 1158px #FFF , 790px 553px #FFF , 1103px 758px #FFF , 226px 1028px #FFF , 1340px 1760px #FFF , 1712px 528px #FFF , 114px 1693px #FFF , 185px 572px #FFF , 1566px 1793px #FFF , 317px 1501px #FFF , 846px 530px #FFF , 1585px 1437px #FFF , 1335px 1009px #FFF , 1768px 436px #FFF , 1131px 666px #FFF , 27px 1543px #FFF , 1778px 1861px #FFF , 1496px 30px #FFF , 1359px 1226px #FFF , 416px 135px #FFF , 1675px 673px #FFF , 296px 524px #FFF , 432px 1822px #FFF , 1995px 416px #FFF , 1206px 1846px #FFF , 542px 603px #FFF , 1811px 1083px #FFF , 1125px 1900px #FFF , 4px 1410px #FFF , 665px 1674px #FFF , 982px 365px #FFF , 809px 534px #FFF , 116px 1381px #FFF , 727px 439px #FFF , 1674px 1407px #FFF , 976px 1762px #FFF , 1585px 28px #FFF , 1916px 624px #FFF , 1716px 1118px #FFF , 1022px 177px #FFF , 807px 619px #FFF , 1657px 338px #FFF , 1608px 1259px #FFF , 405px 1890px #FFF , 433px 1978px #FFF , 1457px 1495px #FFF , 175px 989px #FFF , 850px 1044px #FFF , 170px 444px #FFF , 1623px 71px #FFF , 977px 1319px #FFF , 440px 464px #FFF , 51px 1209px #FFF , 783px 1274px #FFF , 1296px 244px #FFF , 1260px 94px #FFF , 652px 905px #FFF , 805px 1307px #FFF , 947px 822px #FFF , 384px 268px #FFF , 1856px 1782px #FFF , 459px 1844px #FFF , 1679px 473px #FFF , 673px 1832px #FFF , 96px 345px #FFF , 1268px 428px #FFF , 788px 1138px #FFF , 1242px 867px #FFF , 652px 831px #FFF , 993px 1706px #FFF , 1337px 64px #FFF , 1092px 624px #FFF , 674px 1344px #FFF , 1036px 405px #FFF , 996px 1371px #FFF , 1906px 1410px #FFF , 1285px 1079px #FFF , 1756px 583px #FFF , 404px 380px #FFF , 1739px 1620px #FFF , 1253px 372px #FFF , 520px 620px #FFF , 1842px 852px #FFF , 490px 387px #FFF , 1251px 143px #FFF , 1814px 537px #FFF , 1405px 623px #FFF , 1236px 1186px #FFF , 1286px 896px #FFF , 1626px 990px #FFF , 31px 1067px #FFF , 1288px 939px #FFF , 763px 338px #FFF , 713px 1515px #FFF , 859px 1621px #FFF , 1720px 1984px #FFF , 796px 1743px #FFF , 1439px 1587px #FFF , 965px 412px #FFF , 775px 1168px #FFF , 1192px 956px #FFF , 368px 1075px #FFF , 1484px 1154px #FFF , 1784px 547px #FFF , 815px 675px #FFF , 1387px 890px #FFF , 1665px 1733px #FFF , 1948px 429px #FFF , 1665px 92px #FFF , 1806px 919px #FFF , 1712px 494px #FFF , 577px 1922px #FFF , 820px 1228px #FFF , 678px 1745px #FFF , 1421px 586px #FFF , 788px 208px #FFF , 380px 250px #FFF , 748px 977px #FFF , 1637px 337px #FFF , 851px 1514px #FFF , 1487px 1410px #FFF , 1776px 710px #FFF , 544px 453px #FFF , 1707px 1932px #FFF , 1121px 1642px #FFF , 1227px 391px #FFF , 583px 833px #FFF , 658px 278px #FFF , 345px 1388px #FFF , 1529px 1419px #FFF , 233px 1008px #FFF , 892px 943px #FFF , 1431px 1091px #FFF , 1524px 316px #FFF , 1547px 192px #FFF , 976px 36px #FFF , 1648px 1053px #FFF , 1833px 1572px #FFF , 1677px 936px #FFF , 589px 1755px #FFF , 978px 1875px #FFF , 1508px 412px #FFF , 1242px 439px #FFF , 1263px 40px #FFF , 1427px 1736px #FFF , 639px 906px #FFF , 1349px 373px #FFF , 1055px 969px #FFF , 602px 95px #FFF , 224px 1805px #FFF , 1129px 837px #FFF , 1110px 1358px #FFF , 1067px 1752px #FFF , 391px 1389px #FFF , 885px 1979px #FFF , 1188px 414px #FFF , 1931px 325px #FFF , 1853px 1918px #FFF , 636px 1313px #FFF , 1236px 1913px #FFF , 1801px 780px #FFF , 633px 529px #FFF , 1500px 33px #FFF , 1387px 1045px #FFF , 832px 1281px #FFF , 1880px 1845px #FFF , 1477px 1096px #FFF , 1457px 698px #FFF , 1658px 1049px #FFF , 1957px 1151px #FFF , 1561px 1593px #FFF , 627px 250px #FFF , 975px 1575px #FFF , 68px 998px #FFF , 951px 85px #FFF , 280px 431px #FFF , 1683px 1745px #FFF , 322px 778px #FFF , 841px 888px #FFF , 1895px 1883px #FFF , 700px 568px #FFF , 1846px 442px #FFF , 91px 1650px #FFF , 970px 917px #FFF , 1585px 452px #FFF;
}

#stars3 {
  width: 3px;
  height: 3px;
  background: transparent;
  box-shadow: 1679px 1408px #FFF , 1970px 1504px #FFF , 1789px 965px #FFF , 698px 234px #FFF , 1733px 1854px #FFF , 1060px 271px #FFF , 719px 1744px #FFF , 1707px 1847px #FFF , 1710px 432px #FFF , 1325px 1585px #FFF , 92px 577px #FFF , 163px 1938px #FFF , 1885px 123px #FFF , 1566px 1753px #FFF , 1288px 21px #FFF , 1396px 1908px #FFF , 675px 1466px #FFF , 734px 1557px #FFF , 941px 1885px #FFF , 1692px 6px #FFF , 115px 1183px #FFF , 639px 1044px #FFF , 1171px 1982px #FFF , 1801px 1078px #FFF , 648px 820px #FFF , 1885px 1984px #FFF , 268px 1729px #FFF , 1388px 181px #FFF , 1741px 1280px #FFF , 1719px 1080px #FFF , 12px 932px #FFF , 489px 157px #FFF , 1910px 790px #FFF , 115px 44px #FFF , 1748px 1458px #FFF , 282px 109px #FFF , 1100px 1528px #FFF , 543px 598px #FFF , 1320px 1188px #FFF , 1124px 839px #FFF , 1406px 1289px #FFF , 472px 1376px #FFF , 852px 286px #FFF , 510px 860px #FFF , 700px 306px #FFF , 1822px 1302px #FFF , 15px 19px #FFF , 1360px 420px #FFF , 1483px 42px #FFF , 1287px 1867px #FFF , 1105px 1322px #FFF , 745px 161px #FFF , 431px 1722px #FFF , 855px 1254px #FFF , 860px 1784px #FFF , 1578px 1955px #FFF , 1085px 461px #FFF , 472px 690px #FFF , 23px 1152px #FFF , 1625px 601px #FFF , 1177px 1692px #FFF , 397px 1984px #FFF , 10px 1164px #FFF , 1132px 1557px #FFF , 438px 817px #FFF , 1590px 1236px #FFF , 1037px 1616px #FFF , 533px 941px #FFF , 1163px 1992px #FFF , 1451px 1081px #FFF , 1335px 1578px #FFF , 503px 1556px #FFF , 197px 1725px #FFF , 511px 1397px #FFF , 1514px 1164px #FFF , 1249px 148px #FFF , 947px 1849px #FFF , 1258px 1426px #FFF , 255px 1937px #FFF , 23px 529px #FFF , 578px 230px #FFF , 925px 767px #FFF , 903px 365px #FFF , 1861px 451px #FFF , 1813px 912px #FFF , 1597px 637px #FFF , 195px 626px #FFF , 130px 404px #FFF , 725px 408px #FFF , 1916px 843px #FFF , 1336px 239px #FFF , 1568px 1390px #FFF , 139px 126px #FFF , 1287px 1271px #FFF , 731px 465px #FFF , 1959px 1465px #FFF , 909px 169px #FFF , 838px 1332px #FFF , 464px 1037px #FFF , 1893px 233px #FFF;
  animation: animStar 150s linear infinite;
}
#stars3:after {
  content: " ";
  position: absolute;
  top: 2000px;
  width: 3px;
  height: 3px;
  background: transparent;
  box-shadow: 1679px 1408px #FFF , 1970px 1504px #FFF , 1789px 965px #FFF , 698px 234px #FFF , 1733px 1854px #FFF , 1060px 271px #FFF , 719px 1744px #FFF , 1707px 1847px #FFF , 1710px 432px #FFF , 1325px 1585px #FFF , 92px 577px #FFF , 163px 1938px #FFF , 1885px 123px #FFF , 1566px 1753px #FFF , 1288px 21px #FFF , 1396px 1908px #FFF , 675px 1466px #FFF , 734px 1557px #FFF , 941px 1885px #FFF , 1692px 6px #FFF , 115px 1183px #FFF , 639px 1044px #FFF , 1171px 1982px #FFF , 1801px 1078px #FFF , 648px 820px #FFF , 1885px 1984px #FFF , 268px 1729px #FFF , 1388px 181px #FFF , 1741px 1280px #FFF , 1719px 1080px #FFF , 12px 932px #FFF , 489px 157px #FFF , 1910px 790px #FFF , 115px 44px #FFF , 1748px 1458px #FFF , 282px 109px #FFF , 1100px 1528px #FFF , 543px 598px #FFF , 1320px 1188px #FFF , 1124px 839px #FFF , 1406px 1289px #FFF , 472px 1376px #FFF , 852px 286px #FFF , 510px 860px #FFF , 700px 306px #FFF , 1822px 1302px #FFF , 15px 19px #FFF , 1360px 420px #FFF , 1483px 42px #FFF , 1287px 1867px #FFF , 1105px 1322px #FFF , 745px 161px #FFF , 431px 1722px #FFF , 855px 1254px #FFF , 860px 1784px #FFF , 1578px 1955px #FFF , 1085px 461px #FFF , 472px 690px #FFF , 23px 1152px #FFF , 1625px 601px #FFF , 1177px 1692px #FFF , 397px 1984px #FFF , 10px 1164px #FFF , 1132px 1557px #FFF , 438px 817px #FFF , 1590px 1236px #FFF , 1037px 1616px #FFF , 533px 941px #FFF , 1163px 1992px #FFF , 1451px 1081px #FFF , 1335px 1578px #FFF , 503px 1556px #FFF , 197px 1725px #FFF , 511px 1397px #FFF , 1514px 1164px #FFF , 1249px 148px #FFF , 947px 1849px #FFF , 1258px 1426px #FFF , 255px 1937px #FFF , 23px 529px #FFF , 578px 230px #FFF , 925px 767px #FFF , 903px 365px #FFF , 1861px 451px #FFF , 1813px 912px #FFF , 1597px 637px #FFF , 195px 626px #FFF , 130px 404px #FFF , 725px 408px #FFF , 1916px 843px #FFF , 1336px 239px #FFF , 1568px 1390px #FFF , 139px 126px #FFF , 1287px 1271px #FFF , 731px 465px #FFF , 1959px 1465px #FFF , 909px 169px #FFF , 838px 1332px #FFF , 464px 1037px #FFF , 1893px 233px #FFF;
}

#title {
  position: absolute;
  top: 50%;
  left: 0;
  right: 0;
  color: #FFF;
  text-align: center;
  font-family: "lato", sans-serif;
  font-weight: 300;
  font-size: 50px;
  letter-spacing: 10px;
  margin-top: -60px;
  padding-left: 10px;
}
#title span {
  background: -webkit-linear-gradient(white, #38495a);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

@keyframes animStar {
  from {
    transform: translateY(0px);
  }
  to {
    transform: translateY(-2000px);
  }
}
</style>

</head>
<body style="background: radial-gradient(ellipse at bottom, #1b2735 0%, #090a0f 100%)">

<%    
String Sol_ID = (String)session.getAttribute("sol_id"); 
String HeadURL = (String)session.getAttribute("headimgurl");

if(Sol_ID==null || HeadURL==null)
{
	System.out.println("empty session");
	Sol_ID ="Sadden";
	HeadURL = "asset/w5.jpg";
}
%> 

<header class="am-topbar am-topbar-fixed-top">
		<div class="am-container">
			<h1 class="am-topbar-brand">
				<a href="#">So-Link</a>
			</h1>

<!-- 			
				<div class="am-topbar-right">
					
				</div> -->

				<div class="am-topbar-right">
				<h1 class="am-topbar-brand"><%=Sol_ID %></h1>
					<div class="logo-img">
						<img src=<%=HeadURL %> alt>
					</div>
				</div>
			
		</div>
	</header>
<div id='stars'></div>
<div id='stars2'></div>
<div id='stars3'></div>
<div class="am-g" style="margin-top:5%">
	 <br>
    <font size="7" color="white">Search Content</font>
	<%if(request.getAttribute("Picture")!=null){
		Picture pic =(Picture)request.getAttribute("Picture");
		String UserID = pic.getUserId();
		String PicID = pic.getPicId();
		String Time = pic.getTime();
		String URL = pic.getURL();
		String Content = pic.getContent();
		String Tag = pic.getTag();
			%>
		<form action="Update.action" enctype="multipart/form-data" method="post" >
			<p>
			<font size="4" color="white">UserID:</font>
			<font size="5" color="white"><%=UserID%></font>
			<input id="UserID" type="hidden" name="UserID" value=<%=UserID%>/>
			</p>
			<p>
			<font size="4" color="white">PicID:</font>
			<font size="5" color="white"><%=PicID%></font>
			<input id="PicID" type="hidden" name="PicID" value=<%=PicID%>/>
			</p>
			<p>
			<font size="4" color="white">Time:</font>
			<font size="5" color="white"><%=Time%></font>
			<input id="Time" type="hidden" name="Time" value=<%=Time%>/>
			</p>
			<p>
				<font size="4" color="white">Tag:</font> 
				<input type="text" name="Tag" value=<%=Tag %> />
			</p>
			<p>
				<img src="<%=request.getServletContext().getContextPath()+"/images/"+URL%>">				
				<input id="URL" type="hidden" name="URL" value=<%=URL%>/>
			</p>

			<p>
				<font size="4" color="white">Content:</font> 
				 <textarea class="form-control" rows="3" name="Content" ><%=Content %></textarea>
			</p>
			
			<p>
				 <input type="submit" class="btn btn-info" value="OK" />
			</p>
			
		</form>
			<form action="Delete.action" method="post" class="base_form">
			<input id="PicID" type="hidden" name="PicID" value=<%=PicID%> /> 	
			<input type="submit"class="btn btn-danger" value="Delete" />
		</form>
		<%
	}
		%>

	
	</div>
	
		<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.min.js"></script>
	<script src='http://www.5iweb.com.cn/statics/js/jquery.1.7.1.min.js'></script>
    <script src="js/inputshine/index.js"></script> 
</body>
</html>