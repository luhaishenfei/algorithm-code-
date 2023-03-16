package LC.finished;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LC217ContainsDuplicate {
    public static void main(String[] args) {
        LC217ContainsDuplicate l = new LC217ContainsDuplicate();

        int[] ns = {46, 47, 48, 49, 50, 51, 52, 53,52, 54, 55, 56, 57, 58, 59,-24500,-24499,-24498,-24497,-24496,-24495,-24494,-24493,-24492,-24491,-24490,-24489,-24488,-24487,-24486,-24485,-24484,-24483,-24482,-24481,-24480,-24479,-24478,-24477,-24476,-24475,-24474,-24473,-24472,-24471,-24470,-24469,-24468,-24467,-24466,-24465,-24464,-24463,-24462,-24461,-24460,-24459,-24458,-24457,-24456,-24455,-24454,-24453,-24452,-24451,-24450,-24449,-24448,-24447,-24446,-24445,-24444,-24443,-24442,-24441,-24440,-24439,-24438,-24437,-24436,-24435,-24434,-24433,-24432,-24431,-24430,-24429,-24428,-24427,-24426,-24425,-24424,-24423,-24422,-24421,-24420,-24419,-24418,-24417,-24416,-24415,-24414,-24413,-24412,-24411,-24410,-24409,-24408,-24407,-24406,-24405,-24404,-24403,-24402,-24401,-24400,-24399,-24398,-24397,-24396,-24395,-24394,-24393,-24392,-24391,-24390,-24389,-24388,-24387,-24386,-24385,-24384,-24383,-24382,-24381,-24380,-24379,-24378,-24377,-24376,-24375,-24374,-24373,-24372,-24371,-24370,-24369,-24368,-24367,-24366,-24365,-24364,-24363,-24362,-24361,-24360,-24359,-24358,-24357,-24356,-24355,-24354,-24353,-24352,-24351,-24350,-24349,-24348,-24347,-24346,-24345,-24344,-24343,-24342,-24341,-24340,-24339,-24338,-24337,-24336,-24335,-24334,-24333,-24332,-24331,-24330,-24329,-24328,-24327,-24326,-24325,-24324,-24323,-24322,-24321,-24320,-24319,-24318,-24317,-24316,-24315,-24314,-24313,-24312,-24311,-24310,-24309,-24308,-24307,-24306,-24305,-24304,-24303,-24302,-24301,-24300,-24299,-24298,-24297,-24296,-24295,-24294,-24293,-24292,-24291,-24290,-24289,-24288,-24287,-24286,-24285,-24284,-24283,-24282,-24281,-24280,-24279,-24278,-24277,-24276,-24275,-24274,-24273,-24272,-24271,-24270,-24269,-24268,-24267,-24266,-24265,-24264,-24263,-24262,-24261,-24260,-24259,-24258,-24257,-24256,-24255,-24254,-24253,-24252,-24251,-24250,-24249,-24248,-24247,-24246,-24245,-24244,-24243,-24242,-24241,-24240,-24239,-24238,-24237,-24236,-24235,-24234,-24233,-24232,-24231,-24230,-24229,-24228,-24227,-24226,-24225,-24224,-24223,-24222,-24221,-24220,-24219,-24218,-24217,-24216,-24215,-24214,-24213,-24212,-24211,-24210,-24209,-24208,-24207,-24206,-24205,-24204,-24203,-24202,-24201,-24200,-24199,-24198,-24197,-24196,-24195,-24194,-24193,-24192,-24191,-24190,-24189,-24188,-24187,-24186,-24185,-24184,-24183,-24182,-24181,-24180,-24179,-24178,-24177,-24176,-24175,-24174,-24173,-24172,-24171,-24170,-24169,-24168,-24167,-24166,-24165,-24164,-24163,-24162,-24161,-24160,-24159,-24158,-24157,-24156,-24155,-24154,-24153,-24152,-24151,-24150,-24149,-24148,-24147,-24146,-24145,-24144,-24143,-24142,-24141,-24140,-24139,-24138,-24137,-24136,-24135,-24134,-24133,-24132,-24131,-24130,-24129,-24128,-24127,-24126,-24125,-24124,-24123,-24122,-24121,-24120,-24119,-24118,-24117,-24116,-24115,-24114,-24113,-24112,-24111,-24110,-24109,-24108,-24107,-24106,-24105,-24104,-24103,-24102,-24101,-24100,-24099,-24098,-24097,-24096,-24095,-24094,-24093,-24092,-24091,-24090,-24089,-24088,-24087,-24086,-24085,-24084,-24083,-24082,-24081,-24080,-24079,-24078,-24077,-24076,-24075,-24074,-24073,-24072,-24071,-24070,-24069,-24068,-24067,-24066,-24065,-24064,-24063,-24062,-24061,-24060,-24059,-24058,-24057,-24056,-24055,-24054,-24053,-24052,-24051,-24050,-24049,-24048,-24047,-24046,-24045,-24044,-24043,-24042,-24041,-24040,-24039,-24038,-24037,-24036,-24035,-24034,-24033,-24032,-24031,-24030,-24029,-24028,-24027,-24026,-24025,-24024,-24023,-24022,-24021,-24020,-24019,-24018,-24017,-24016,-24015,-24014,-24013,-24012,-24011,-24010,-24009,-24008,-24007,-24006,-24005,-24004,-24003,-24002,-24001,-24000,-23999,-23998,-23997,-23996,-23995,-23994,-23993,-23992,-23991,-23990,-23989,-23988,-23987,-23986,-23985,-23984,-23983,-23982,-23981,-23980,-23979,-23978,-23977,-23976,-23975,-23974,-23973,-23972,-23971,-23970,-23969,-23968,-23967,-23966,-23965,-23964,-23963,-23962,-23961,-23960,-23959,-23958,-23957,-23956,-23955,-23954,-23953,-23952,-23951,-23950,-23949,-23948,-23947,-23946,-23945,-23944,-23943,-23942,-23941,-23940,-23939,-23938,-23937,-23936,-23935,-23934,-23933,-23932,-23931,-23930,-23929,-23928,-23927,-23926,-23925,-23924,-23923,-23922,-23921,-23920,-23919,-23918,-23917,-23916,-23915,-23914,-23913,-23912,-23911,-23910,-23909,-23908,-23907,-23906,-23905,-23904,-23903,-23902,-23901,-23900,-23899,-23898,-23897,-23896,-23895,-23894,-23893,-23892,-23891,-23890,-23889,-23888,-23887,-23886,-23885,-23884,-23883,-23882,-23881,-23880,-23879,-23878,-23877,-23876,-23875,-23874,-23873,-23872,-23871,-23870,-23869,-23868,-23867,-23866,-23865,-23864,-23863,-23862,-23861,-23860,-23859,-23858,-23857,-23856,-23855,-23854,-23853,-23852,-23851,-23850,-23849,-23848,-23847,-23846,-23845,-23844,-23843,-23842,-23841,-23840,-23839,-23838,-23837,-23836,-23835,-23834,-23833,-23832,-23831,-23830,-23829,-23828,-23827,-23826,-23825,-23824,-23823,-23822,-23821,-23820,-23819,-23818,-23817,-23816,-23815,-23814,-23813,-23812,-23811,-23810,-23809,-23808,-23807,-23806,-23805,-23804,-23803,-23802,-23801,-23800,-23799,-23798,-23797,-23796,-23795,-23794,-23793,-23792,-23791,-23790,-23789,-23788,-23787,-23786,-23785,-23784,-23783,-23782,-23781,-23780,-23779,-23778,-23777,-23776,-23775,-23774,-23773,-23772,-23771,-23770,-23769,-23768,-23767,-23766,-23765,-23764,-23763,-23762,-23761,-23760,-23759,-23758,-23757,-23756,-23755,-23754,-23753,-23752,-23751,-23750,-23749,-23748,-23747,-23746,-23745,-23744,-23743,-23742,-23741,-23740,-23739,-23738,-23737,-23736,-23735,-23734,-23733,-23732,-23731,-23730,-23729,-23728,-23727,-23726,-23725,-23724,-23723,-23722,-23721,-23720,-23719,-23718,-23717,-23716,-23715,-23714,-23713,-23712,-23711,-23710,-23709,-23708,-23707,-23706,-23705,-23704,-23703,-23702,-23701,-23700,-23699,-23698,-23697,-23696,-23695,-23694,-23693,-23692,-23691,-23690,-23689,-23688,-23687,-23686,-23685,-23684,-23683,-23682,-23681,-23680,-23679,-23678,-23677,-23676,-23675,-23674,-23673,-23672,-23671,-23670,-23669,-23668,-23667,-23666,-23665,-23664,-23663,-23662,-23661,-23660,-23659,-23658,-23657,-23656,-23655,-23654,-23653,-23652,-23651,-23650,-23649,-23648,-23647,-23646,-23645,-23644,-23643,-23642,-23641,-23640,-23639,-23638,-23637,-23636,-23635,-23634,-23633,-23632,-23631,-23630,-23629,-23628,-23627,-23626,-23625,-23624,-23623,-23622,-23621,-23620,-23619,-23618,-23617,-23616,-23615,-23614,-23613,-23612,-23611,-23610,-23609,-23608,-23607,-23606,-23605,-23604,-23603,-23602,-23601,-23600,-23599,-23598,-23597,-23596,-23595,-23594,-23593,-23592,-23591,-23590,-23589,-23588,-23587,-23586,-23585,-23584,-23583,-23582,-23581,-23580,-23579,-23578,-23577,-23576,-23575,-23574,-23573,-23572,-23571,-23570,-23569,-23568,-23567,-23566,-23565,-23564,-23563,-23562,-23561,-23560,-23559,-23558,-23557,-23556,-23555,-23554,-23553,-23552,-23551,-23550,-23549,-23548,-23547,-23546,-23545,-23544,-23543,-23542,-23541,-23540,-23539,-23538,-23537,-23536,-23535,-23534,-23533,-23532,-23531,-23530,-23529,-23528,-23527,-23526,-23525,-23524,-23523,-23522,-23521,-23520,-23519,-23518,-23517,-23516,-23515,-23514,-23513,-23512,-23511,-23510,-23509,-23508,-23507,-23506,-23505,-23504,-23503,-23502,-23501,-23500,-23499,-23498,-23497,-23496,-23495,-23494,-23493,-23492,-23491,-23490,-23489,-23488,-23487,-23486,-23485,-23484,-23483,-23482,-23481,-23480,-23479,-23478,-23477,-23476,-23475,-23474,-23473,-23472,-23471,-23470,-23469,-23468,-23467,-23466,-23465,-23464,-23463,-23462,-23461,-23460,-23459,-23458,-23457,-23456,-23455,-23454,-23453,-23452,-23451,-23450,-23449,-23448,-23447,-23446,-23445,-23444,-23443,-23442,-23441,-23440,-23439,-23438,-23437,-23436,-23435,-23434,-23433,-23432,-23431,-23430,-23429,-23428,-23427,-23426,-23425,-23424,-23423,-23422,-23421,-23420,-23419,-23418,-23417,-23416,-23415,-23414,-23413,-23412,-23411,-23410,-23409,-23408,-23407,-23406,-23405,-23404,-23403,-23402,-23401,-23400,-23399,-23398,-23397,-23396,-23395,-23394,-23393,-23392,-23391,-23390,-23389,-23388,-23387,-23386,-23385,-23384,-23383,-23382,-23381,-23380,-23379,-23378,-23377,-23376,-23375,-23374,-23373,-23372,-23371,-23370,-23369,-23368,-23367,-23366,-23365,-23364,-23363,-23362,-23361,-23360,-23359,-23358,-23357,-23356,-23355,-23354,-23353,-23352,-23351,-23350,-23349,-23348,-23347,-23346,-23345,-23344,-23343,-23342,-23341,-23340,-23339,-23338,-23337,-23336,-23335,-23334,-23333,-23332,-23331,-23330,-23329,-23328,-23327,-23326,-23325,-23324,-23323,-23322,-23321,-23320,-23319,-23318,-23317,-23316,-23315,-23314,-23313,-23312,-23311,-23310,-23309,-23308,-23307,-23306,-23305,-23304,-23303,-23302,-23301,-23300,-23299,-23298,-23297,-23296,-23295,-23294,-23293,-23292,-23291,-23290,-23289,-23288,-23287,-23286,-23285,-23284,-23283,-23282,-23281,-23280,-23279,-23278,-23277,-23276,-23275,-23274,-23273,-23272,-23271,-23270,-23269,-23268,-23267,-23266,-23265,-23264,-23263,-23262,-23261,-23260,-23259,-23258,-23257,-23256,-23255,-23254,-23253,-23252,-23251,-23250,-23249,-23248,-23247,-23246,-23245,-23244,-23243,-23242,-23241,-23240,-23239,-23238,-23237,-23236,-23235,-23234,-23233,-23232,-23231,-23230,-23229,-23228,-23227,-23226,-23225,-23224,-23223,-23222,-23221,-23220,-23219,-23218,-23217,-23216,-23215,-23214,-23213,-23212,-23211,-23210,-23209,-23208,-23207,-23206,-23205,-23204,-23203,-23202,-23201,-23200,-23199,-23198,-23197,-23196,-23195,-23194,-23193,-23192,-23191,-23190,-23189,-23188,-23187,-23186,-23185,-23184,-23183,-23182,-23181,-23180,-23179,-23178,-23177,-23176,-23175,-23174,-23173,-23172,-23171,-23170,-23169,-23168,-23167,-23166,-23165,-23164,-23163,-23162,-23161,-23160,-23159,-23158,-23157,-23156,-23155,-23154,-23153,-23152,-23151,-23150,-23149,-23148,-23147,-23146,-23145,-23144,-23143,-23142,-23141,-23140,-23139,-23138,-23137,-23136,-23135,-23134,-23133,-23132,-23131,-23130,-23129,-23128,-23127,-23126,-23125,-23124,-23123,-23122,-23121,-23120,-23119,-23118,-23117,-23116,-23115,-23114,-23113,-23112,-23111,-23110,-23109,-23108,-23107,-23106,-23105,-23104,-23103,-23102,-23101,-23100,-23099,-23098,-23097,-23096,-23095,-23094,-23093,-23092,-23091,-23090,-23089,-23088,-23087,-23086,-23085,-23084,-23083,-23082,-23081,-23080,-23079,-23078,-23077,-23076,-23075,-23074,-23073,-23072,-23071,-23070,-23069,-23068,-23067,-23066,-23065,-23064,-23063,-23062,-23061,-23060,-23059,-23058,-23057,-23056,-23055,-23054,-23053,-23052,-23051,-23050,-23049,-23048,-23047,-23046,-23045,-23044,-23043,-23042,-23041,-23040,-23039,-23038,-23037,-23036,-23035,-23034,-23033,-23032,-23031,-23030,-23029,-23028,-23027,-23026,-23025,-23024,-23023,-23022,-23021,-23020,-23019,-23018,-23017,-23016,-23015,-23014,-23013,-23012,-23011,-23010,-23009,-23008,-23007,-23006,-23005,-23004,-23003,-23002,-23001,-23000,-22999,-22998,-22997,-22996,-22995,-22994,-22993,-22992,-22991,-22990,-22989,-22988,-22987,-22986,-22985,-22984,-22983,-22982,-22981,-22980,-22979,-22978,-22977,-22976,-22975,-22974,-22973,-22972,-22971,-22970,-22969,-22968,-22967,-22966,-22965,-22964,-22963,-22962,-22961,-22960,-22959,-22958,-22957,-22956,-22955,-22954,-22953,-22952,-22951,-22950,-22949,-22948,-22947,-22946,-22945,-22944,-22943,-22942,-22941,-22940,-22939,-22938,-22937,-22936,-22935,-22934,-22933,-22932,-22931,-22930,-22929,-22928,-22927,-22926,-22925,-22924,-22923,-22922,-22921,-22920,-22919,-22918,-22917,-22916,-22915,-22914,-22913,-22912,-22911,-22910,-22909,-22908,-22907,-22906,-22905,-22904,-22903,-22902,-22901,-22900,-22899,-22898,-22897,-22896,-22895,-22894,-22893,-22892,-22891,-22890,-22889,-22888,-22887,-22886,-22885,-22884,-22883,-22882,-22881,-22880,-22879,-22878,-22877,-22876,-22875,-22874,-22873,-22872,-22871,-22870,-22869,-22868,-22867,-22866,-22865,-22864,-22863,-22862,-22861,-22860,-22859,-22858,-22857,-22856,-22855,-22854,-22853,-22852,-22851,-22850,-22849,-22848,-22847,-22846,-22845,-22844,-22843,-22842,-22841,-22840,-22839,-22838,-22837,-22836,-22835,-22834,-22833,-22832,-22831,-22830,-22829,-22828,-22827,-22826,-22825,-22824,-22823,-22822,-22821,-22820,-22819,-22818,-22817,-22816,-22815,-22814,-22813,-22812,-22811,-22810,-22809,-22808,-22807,-22806,-22805,-22804,-22803,-22802,-22801,-22800,-22799,-22798,-22797,-22796,-22795,-22794,-22793,-22792,-22791,-22790,-22789,-22788,-22787,-22786,-22785,-22784,-22783,-22782,-22781,-22780,-22779,-22778,-22777,-22776,-22775,-22774,-22773,-22772,-22771,-22770,-22769,-22768,-22767,-22766,-22765,-22764,-22763,-22762,-22761,-22760,-22759,-22758,-22757,-22756,-22755,-22754,-22753,-22752,-22751,-22750,-22749,-22748,-22747,-22746,-22745,-22744,-22743,-22742,-22741,-22740,-22739,-22738,-22737,-22736,-22735,-22734,-22733,-22732,-22731,-22730,-22729,-22728,-22727,-22726,-22725,-22724,-22723,-22722,-22721,-22720,-22719,-22718,-22717,-22716,-22715,-22714,-22713,-22712,-22711,-22710,-22709,-22708,-22707,-22706,-22705,-22704,-22703,-22702,-22701,-22700,-22699,-22698,-22697,-22696,-22695,-22694,-22693,-22692,-22691,-22690,-22689,-22688,-22687,-22686,-22685,-22684,-22683,8040,28041,28042,28043,28044,28045,28046,28047,28048,28049,28050,28051,28052,28053,28054,28055,28056,28057,28058,28059,28060,28061,28062,28063,28064,28065,28066,28067,28068,28069,28070,28071,28072,28073,28074,28075,28076,28077,28078,28079,28080,28081,28082,28083,28084,28085,28086,28087,28088,28089,28090,28091,28092,28093,28094,28095,28096,28097,28098,28099,28100,28101,28102,28103,28104,28105,28106,28107,28108,28109,28110,28111,28112,28113,28114,28115,28116,28117,28118,28119,28120,28121,28122,28123,28124,28125,28126,28127,28128,28129,28130,28131,28132,28133,28134,28135,28136,28137,28138,28139,28140,28141,28142,28143,28144,28145,28146,28147,28148,28149,28150,28151,28152,28153,28154,28155,28156,28157,28158,28159,28160,28161,28162,28163,28164,28165,28166,28167,28168,28169,28170,28171,28172,28173,28174,28175,28176,28177,28178,28179,28180,28181,28182,28183,28184,28185,28186,28187,28188,28189,28190,28191,28192,28193,28194,28195,28196,28197,28198,28199,28200,28201,28202,28203,28204,28205,28206,28207,28208,28209,28210,28211,28212,28213,28214,28215,28216,28217,28218,28219,28220,28221,28222,28223,28224,28225,28226,28227,28228,28229,28230,28231,28232,28233,28234,28235,28236,28237,28238,28239,28240,28241,28242,28243,28244,28245,28246,28247,28248,28249,28250,28251,28252,28253,28254,28255,28256,28257,28258,28259,28260,28261,28262,28263,28264,28265,28266,28267,28268,28269,28270,28271,28272,28273,28274,28275,28276,28277,28278,28279,28280,28281,28282,28283,28284,28285,28286,28287,28288,28289,28290,28291,28292,28293,28294,28295,28296,28297,28298,28299,28300,28301,28302,28303,28304,28305,28306,28307,28308,28309,28310,28311,28312,28313,28314,28315,28316,28317,28318,28319,28320,28321,28322,28323,28324,28325,28326,28327,28328,28329,28330,28331,28332,28333,28334,28335,28336,28337,28338,28339,28340,28341,28342,28343,28344,28345,28346,28347,28348,28349,28350,28351,28352,28353,28354,28355,28356,28357,28358,28359,28360,28361,28362,28363,28364,28365,28366,28367,28368,28369,28370,28371,28372,28373,28374,28375,28376,28377,28378,28379,28380,28381,28382,28383,28384,28385,28386,28387,28388,28389,28390,28391,28392,28393,28394,28395,28396,28397,28398,28399,28400,28401,28402,28403,28404,28405,28406,28407,28408,28409,28410,28411,28412,28413,28414,28415,28416,28417,28418,28419,28420,28421,28422,28423,28424,28425,28426,28427,28428,28429,28430,28431,28432,28433,28434,28435,28436,28437,28438,28439,28440,28441,28442,28443,28444,28445,28446,28447,28448,28449,28450,28451,28452,28453,28454,28455,28456,28457,28458,28459,28460,28461,28462,28463,28464,28465,28466,28467,28468,28469,28470,28471,28472,28473,28474,28475,28476,28477,28478,28479,28480,28481,28482,28483,28484,28485,28486,28487,28488,28489,28490,28491,28492,28493,28494,28495,28496,28497,28498,28499,28500,28501,28502,28503,28504,28505,28506,28507,28508,28509,28510,28511,28512,28513,28514,28515,28516,28517,28518,28519,28520,28521,28522,28523,28524,28525,28526,28527,28528,28529,28530,28531,28532,28533,28534,28535,28536,28537,28538,28539,28540,28541,28542,28543,28544,28545,28546,28547,28548,28549,28550,28551,28552,28553,28554,28555,28556,28557,28558,28559,28560,28561,28562,28563,28564,28565,28566,28567,28568,28569,28570,28571,28572,28573,28574,28575,28576,28577,28578,28579,28580,28581,28582,28583,28584,28585,28586,28587,28588,28589,28590,28591,28592,28593,28594,28595,28596,28597,28598,28599,28600,28601,28602,28603,28604,28605,28606,28607,28608,28609,28610,28611,28612,28613,28614,28615,28616,28617,28618,28619,28620,28621,28622,28623,28624,28625,28626,28627,28628,28629,28630,28631,28632,28633,28634,28635,28636,28637,28638,28639,28640,28641,28642,28643,28644,28645,28646,28647,28648,28649,28650,28651,28652,28653,28654,28655,28656,28657,28658,28659,28660,28661,28662,28663,28664,28665,28666,28667,28668,28669,28670,28671,28672,28673,28674,28675,28676,28677,28678,28679,28680,28681,28682,28683,28684,28685,28686,28687,28688,28689,28690,28691,28692,28693,28694,28695,28696,28697,28698,28699,28700,28701,28702,28703,28704,28705,28706,28707,28708,28709,28710,28711,28712,28713,28714,28715,28716,28717,28718,28719,28720,28721,28722,28723,28724,28725,28726,28727,28728,28729,28730,28731,28732,28733,28734,28735,28736,28737,28738,28739,28740,28741,28742,28743,28744,28745,28746,28747,28748,28749,28750,28751,28752,28753,28754,28755,28756,28757,28758,28759,28760,28761,28762,28763,28764,28765,28766,28767,28768,28769,28770,28771,28772,28773,28774,28775,28776,28777,28778,28779,28780,28781,28782,28783,28784,28785,28786,28787,28788,28789,28790,28791,28792,28793,28794,28795,28796,28797,28798,28799,28800,28801,28802,28803,28804,28805,28806,28807,28808,28809,28810,28811,28812,28813,28814,28815,28816,28817,28818,28819,28820,28821,28822,28823,28824,28825,28826,28827,28828,28829,28830,28831,28832,28833,28834,28835,28836,28837,28838,28839,28840,28841,28842,28843,28844,28845,28846,28847,28848,28849,28850,28851,28852,28853,28854,28855,28856,28857,28858,28859,28860,28861,28862,28863,28864,28865,28866,28867,28868,28869,28870,28871,28872,28873,28874,28875,28876,28877,28878,28879,28880,28881,28882,28883,28884,28885,28886,28887,28888,28889,28890,28891,28892,28893,28894,28895,28896,28897,28898,28899,28900,28901,28902,28903,28904,28905,28906,28907,28908,28909,28910,28911,28912,28913,28914,28915,28916,28917,28918,28919,28920,28921,28922,28923,28924,28925,28926,28927,28928,28929,28930,28931,28932,28933,28934,28935,28936,28937,28938,28939,28940,28941,28942,28943,28944,28945,28946,28947,28948,28949,28950,28951,28952,28953,28954,28955,28956,28957,28958,28959,28960,28961,28962,28963,28964,28965,28966,28967,28968,28969,28970,28971,28972,28973,28974,28975,28976,28977,28978,28979,28980,28981,28982,28983,28984,28985,28986,28987,28988,28989,28990,28991,28992,28993,28994,28995,28996,28997,28998,28999,29000,29001,29002,29003,29004,29005,29006,29007,29008,29009,29010,29011,29012,29013,29014,29015,29016,29017,29018,29019,29020,29021,29022,29023,29024,29025,29026,29027,29028,29029,29030,29031,29032,29033,29034,29035,29036,29037,29038,29039,29040,29041,29042,29043,29044,29045,29046,29047,29048,29049,29050,29051,29052,29053,29054,29055,29056,29057,29058,29059,29060,29061,29062,29063,29064,29065,29066,29067,29068,29069,29070,29071,29072,29073,29074,29075,29076,29077,29078,29079,29080,29081,29082,29083,29084,29085,29086,29087,29088,29089,29090,29091,29092,29093,29094,29095,29096,29097,29098,29099,29100,29101,29102,29103,29104,29105,29106,29107,29108,29109,29110,29111,29112,29113,29114,29115,29116,29117,29118,29119,29120,29121,29122,29123,29124,29125,29126,29127,29128,29129,29130,29131,29132,29133,29134,29135,29136,29137,29138,29139,29140,29141,29142,29143,29144,29145,29146,29147,29148,29149,29150,29151,29152,29153,29154,29155,29156,29157,29158,29159,29160,29161,29162,29163,29164,29165,29166,29167,29168,29169,29170,29171,29172,29173,29174,29175,29176,29177,29178,29179,29180,29181,29182,29183,29184,29185,29186,29187,29188,29189,29190,29191,29192,29193,29194,29195,29196,29197,29198,29199,29200,29201,29202,29203,29204,29205,29206,29207,29208,29209,29210,29211,29212,29213,29214,29215,29216,29217,29218,29219,29220,29221,29222,29223,29224,29225,29226,29227,29228,29229,29230,29231,29232,29233,29234,29235,29236,29237,29238,29239,29240,29241,29242,29243,29244,29245,29246,29247,29248,29249,29250,29251,29252,29253,29254,29255,29256,29257,29258,29259,29260,29261,29262,29263,29264,29265,29266,29267,29268,29269,29270,29271,29272,29273,29274,29275,29276,29277,29278,29279,29280,29281,29282,29283,29284,29285,29286,29287,29288,29289,29290,29291,29292,29293,29294,29295,29296,29297,29298,29299,29300,29301,29302,29303,29304,29305,29306,29307,29308,29309,29310,29311,29312,29313,29314,29315,29316,29317,29318,29319,29320,29321,29322,29323,29324,29325,29326,29327,29328,29329,29330,29331,29332,29333,29334,29335,29336,29337,29338,29339,29340,29341,29342,29343,29344,29345,29346,29347,29348,29349,29350,29351,29352,29353,29354,29355,29356,29357,29358,29359,29360,29361,29362,29363,29364,29365,29366,29367,29368,29369,29370,29371,29372,29373,29374,29375,29376,29377,29378,29379,29380,29381,29382,29383,29384,29385,29386,29387,29388,29389,29390,29391,29392,29393,29394,29395,29396,29397,29398,29399,29400,29401,29402,29403,29404,29405,29406,29407,29408,29409,29410,29411,29412,29413,29414,29415,29416,29417,29418,29419,29420,29421,29422,29423,29424,29425,29426,29427,29428,29429,29430,29431,29432,29433,29434,29435,29436,29437,29438,29439,29440,29441,29442,29443,29444,29445,29446,29447,29448,29449,29450,29451,29452,29453,29454,29455,29456,29457,29458,29459,29460,29461,29462,29463,29464,29465,29466,29467,29468,29469,29470,29471,29472,29473,29474,29475,29476,29477,29478,29479,29480,29481,29482,29483,29484,29485,29486,29487,29488,29489,29490,29491,29492,29493,29494,29495,29496,29497,29498,29499,29500,29501,29502,29503,29504,29505,29506,29507,29508,29509,29510,29511,29512,29513,29514,29515,29516,29517,29518,29519,29520,29521,29522,29523,29524,29525,29526,29527,29528,29529,29530,29531,29532,29533,29534,29535,29536,29537,29538,29539,29540,29541,29542,29543,29544,29545,29546,29547,29548,29549,29550,29551,29552,29553,29554,29555,29556,29557,29558,29559,29560,29561,29562,29563,29564,29565,29566,29567,29568,29569,29570,29571,29572,29573,29574,29575,29576,29577,29578,29579,29580,29581,29582,29583,29584,29585,29586,29587,29588,29589,29590,29591,29592,29593,29594,29595,29596,29597,29598,29599,29600,29601,29602,29603,29604,29605,29606,29607,29608,29609,29610,29611,29612,29613,29614,29615,29616,29617,29618,29619,29620,29621,29622,29623,29624,29625,29626,29627,29628,29629,29630,29631,29632,29633,29634,29635,29636,29637,29638,29639,29640,29641,29642,29643,29644,29645,29646,29647,29648,29649,29650,29651,29652,29653,29654,29655,29656,29657,29658,29659,29660,29661,29662,29663,29664,29665,29666,29667,29668,29669,29670,29671,29672,29673,29674,29675,29676,29677,29678,29679,29680,29681,29682,29683,29684,29685,29686,29687,29688,29689,29690,29691,29692,29693,29694,29695,29696,29697,29698,29699,29700,29701,29702,29703,29704,29705,29706,29707,29708,29709,29710,29711,29712,29713,29714,29715,29716,29717,29718,29719,29720,29721,29722,29723,29724,29725,29726,29727,29728,29729,29730,29731,29732,29733,29734,29735,29736,29737,29738,29739,29740,29741,29742,29743,29744,29745,29746,29747,29748,29749,29750,29751,29752,29753,29754,29755,29756,29757,29758,29759,29760,29761,29762,29763,29764,29765,29766,29767,29768,29769,29770,29771,29772,29773,29774,29775,29776,29777,29778,29779,29780,29781,29782,29783,29784,29785,29786,29787,29788,29789,29790,29791,29792,29793,29794,29795,29796,29797,29798,29799,29800,29801,29802,29803,29804,29805,29806,29807,29808,29809,29810,29811,29812,29813,29814,29815,29816,29817,29818,29819,29820,29821,29822,29823,29824,29825,29826,29827,29828,29829,29830,29831,29832,29833,29834,29835,29836,29837,29838,29839,29840,29841,29842,29843,29844,29845,29846,29847,29848,29849,29850,29851,29852,29853,29854,29855,29856,29857,29858,29859,29860,29861,29862,29863,29864,29865,29866,29867,29868,29869,29870,29871,29872,29873,29874,29875,29876,29877,29878,29879,29880,29881,29882,29883,29884,29885,29886,29887,29888,29889,29890,29891,29892,29893,29894,29895,29896,29897,29898,29899,29900,29901,29902,29903,29904,29905,29906,29907,29908,29909,29910,29911,29912,29913,29914,29915,29916,29917,29918,29919,29920,29921,29922,29923,29924,29925,29926,29927,29928,29929,29930,29931,29932,29933,29934,29935,29936,29937,29938,29939,29940,29941,29942,29943,29944,29945,29946,29947,29948,29949,29950,29951,29952,29953,29954,29955,29956,29957,29958,29959,29960,29961,29962,29963,29964,29965,29966,29967,29968,29969,29970,29971,29972,29973,29974,29975,29976,29977,29978,29979,29980,29981,29982,29983,29984,29985,29986,29987,29988,29989,29990,29991,29992,29993,29994,29995,29996,29997,29998,29999};
        long timer=System.currentTimeMillis();
        System.out.println(l.containsDuplicate(ns));
        timer=System.currentTimeMillis()-timer;
        System.out.println(timer);
        System.out.println("--------");
        timer=System.currentTimeMillis();
        System.out.println(l.containsDuplicateLC(ns));
        timer=System.currentTimeMillis()-timer;
        System.out.println(timer);

    }


    public boolean containsDuplicate(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                return true;
            } else {
                list.add(nums[i]);
            }
        }
        return false;
    }

    public boolean containsDuplicateLC(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

}
