<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/img/my_ico.ico">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/common.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/texiao2.js"></script>
<script
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/kkpager.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/kkpager_blue.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrapValidator.min.css" />
<title>规章制度</title>
</head>
<body>
	<div class="top">
			<div class="top-inner">
				<div class="logo">
					<!-- 网站logo图片地址请在本组件"内容配置-网站logo"处填写 -->
					<a href="../index.jsp"><img src="<%=request.getContextPath()%>/img/logo.png" width="321" height="71" alt="logo"></a>
					<!--#endeditable-->

				</div>
				<div class="nav">
					<ul>
						<li><a href="#">社团概况</a>
							<ol style="display:none;">
								<a href="<%=request.getContextPath()%>/common/introduction">
									<li>社团简介</li></a>
								<a href="<%=request.getContextPath()%>/common/rule">
									<li>规章制度</li></a>
							</ol> 

						</li>

						<li><a href="#">工作指南</a>
						
							<ol style="display: none; margin-left: -1px; width: 262px; height: 93px; background: url(&quot;img/xiaoxiala_03_011_02.png&quot;);">

								<a href="<%=request.getContextPath()%>/common/workflow">
									<li>工作流程</li>
								</a>

								<a href="<%=request.getContextPath()%>/common/guidence">
									<li>使用指南</li>
								</a>
							</ol>

						</li>

						<li><a href="#">星级评定</a>
							<ol style="display: none; margin-left: -1px; width: 262px; height: 93px; background: url(&quot;img/xiaoxiala_03_011_02.png&quot;);">
								<a href="<%=request.getContextPath()%>/common/monthly_review">
									<li>社团月评</li>
								</a>

								<a href="<%=request.getContextPath()%>/common/year_review">
									<li>年度总评</li>
								</a>
							</ol>

						</li>

						<li><a href="#">走进社团</a>
							
							<ol style="display: none; margin-left: -1px; width: 262px; height: 241px; background: url(&quot;img/xiaoxiala_03_011_02.png&quot;);">

								<a href="<%=request.getContextPath()%>/common/society_style">
									<li>社团风采</li>
								</a>

								<a href="<%=request.getContextPath()%>/common/society_star">
									<li>社团明星</li>
								</a>

							</ol>

						</li>

						<li><a href="#">在线留言</a>

						</li>

						<li>
							<button style="background-color: #9a0e14;border-color: #9a0e14;" class="btn btn-danger" id="userlogin"><span class="glyphicon glyphicon-user"></span>&nbsp;立即登录</button>
						</li>
					</ul>

				</div>

			</div>
		</div>
	<!-- 首部 -->
	<!-- 
		<div class="weizhi">
			
			<div class="weizhi-inner">
				当前位置:
				<a href="http://127.0.0.1:8020/society/index.html" target="_top">首页</a> &gt;
				<a href="http://127.0.0.1:8020/society/index.html" target="_top">系统公告</a> &gt; 正文
			</div>
		</div> -->
	<div class="panel panel-default">
		<div class="panel-body" style="height: 100%;">
			<div class="list-contain">
				<div class="list-contain-inner">
					<div class="slide-guideline">
						<div class="tittle margintop">
							<!--#begineditable "栏目名称侧面" -->
							规章制度
							<!--#endeditable-->
						</div>
						<div style="clear: both"></div>
						<ul>
							<!--#begineditable "侧边导航" -->

							<!--#endeditable-->
						</ul>

					</div>
					<div class="slide-list">
						<!--#begineditable "栏目名称" -->
						<h1>规章制度</h1>
						<!--#endeditable-->
						<hr>
						<div class="neirong">
							
<div>
    <h1 align="center">徐州工程学院学生社团管理章程</h1>

    <div class="wenzi" id="vsb_content"><h4><p class="vsbcontent_start">第一章 总则</p>
</h4><p>第一条 为规范我校学生社团的登记与管理，维护学生社团的正当权益，促进我校校园文化建设，制定本章程。</p>
<p>第二条 本章程所称徐州工程学院学生社团（以下简称“社团”），是指由徐州工程学院学生在共同志向、兴趣、爱好和责任感的基础上自发组织的依照其章程开展活动并自行承担相应责任和义务的非营利性学生群众组织。</p>
<p>第三条 社团实行登记注册成立、学期注册和活动审批的基本管理办法。</p>
<p>第四条 社团必须遵守国家法律法规，遵守学校规章制度。不得危害国家统一、民族团结，不得损害社会公共利益和学校利益以及其他学生组织和学生的正当权益，不得违背社会道德风尚。</p>
<p>第五条 社团的基本任务：遵循和贯彻党的教育方针，积极开展健康有益、丰富多彩的校园文化活动，推动我校学生综合素质的全面提高。</p>
<p>第六条 社团的活动经费通过会费缴纳、学校学生活动经费及企业赞助等其他合法方式获得。社团不得从事营利性经营活动。</p>
<p>第七条 社团由学校党委领导，在学校团委的指导下开展活动。 </p>
<h4><p>第二章社团成员及管理机构</p>
</h4><p>第八条 社团的所有成员必须是具有徐州工程学院正式学籍的全日制学生。</p>
<p>第九条 社团负责人和骨干成员纳入学校学生骨干培养体系，外籍及港澳台学生担任社团负责人须到学校相关主管部门审批备案。</p>
<p>第十条 学校团委指导成立徐州工程学院学生社团联合会，负责全校社团的登记管理、指导监督、考核评比等工作，社团须接受校团委、校学生社团联合会的指导、管理和监督。</p>
<p>第十一条 社团需具备固定的指导单位和指导教师，指导单位应是徐州工程学院所属机关部门、学院、科室、研究所等，指导教师应是徐州工程学院正式编制教师。指导单位和指导教师需对所指导的社团进行必要的指导、监督和管理。</p>
<p>第十二条 社团需根据发展需要和团员人数成立团支部，接受共青团徐州工程学院学生社团工作委员会的领导。</p>
<p>第十三条 我校学生社团实行校院两级社团管理体系，校级社团在校团委登记注册成立，在各机关单位、学院、科室、研究所等指导单位的具体指导下面向全校纳新并开展活动。院级社团在学院团委登记注册成立，在学院团委或学院有关科室、研究所的指导下面向所在学院纳新并开展活动，院级社团名称前需冠有学院名称。院级品牌社团和特色社团的重点活动，经院团委认定有必要面向全校开展的活动，报经校团委同意后，可以面向全校开展活动。院团委可参照本章程制定本学院的社团管理章程及实施细则等。</p>
<h4><p>第三章 社团的成立</p>
</h4><p>第十四条 申请成立校级社团，需先在所在学院团委注册成立院级社团（院级社团成立办法请咨询所在学院团委），经过一段时间的建设与发展，社团在全校社团年度评比中成绩优异或院团委认定该社团日常表现出色，可由院团委报校团委批准予以注册成立。该社团原指导单位和指导教师不变。校团委每年也将根据全校社团建设与发展规划定期安排部分品牌性院级特色社团集中转为校级社团。校团委也可根据规划，直接面向全校学生征募急需注册成立的校级社团。</p>
<p>第十五条 转为校级社团或直接注册校级社团，应当具备下列条件：</p>
<p>（一） 有规范的名称和相应的组织机构，学生社团的名称应冠以"徐州工程学院学生XX协会/俱乐部/社"等字样，不得违背校园文明风尚，且应当与其性质相符，准确反映其特征；</p>
<p>（二） 有相对固定的社团指导教师和指导单位，指导教师和指导单位须熟悉该社团的活动内容并能胜任对其工作的指导。学生社团可以聘请校内外专家、学者、教师、企业家等担任社团的名誉职务，但须事先征得校团委同意。</p>
<p>第十六条 转为校级社团，社团负责人应当在校团委的指导下向学工部或研工部提交下列文件：（一） 筹备申请书（二） 章程草案（三） 发起人和拟任负责人情况登记表（四）社团指导教师（指导单位）情况登记表。</p>
<p>第十五条 社团章程应当包括下列事项：（一） 名称；（二） 宗旨、活动范围和活动方式；（三） 社团成员资格及其权利、义务；（四） 组织管理制度、执行机构的产生程序及权限；（五）负责人的条件、权限和产生、罢免的程序；（六） 章程的修改程序；（七） 社团的终止程序；（八） 应当由章程规定的其他事项。</p>
<p>第十七条 校团委、学工部、研工部在收到申请2个周之内作出批准或不批准筹备的决定；不批准的，应当向发起人说明理由。</p>
<p>第十八条 有下列情形之一的，不予批准：</p>
<p>（一） 社团的宗旨、任务不符合本章程第四条、第五条的规定的；</p>
<p>（二） 已有性质宗旨相同或者相似的社团；</p>
<p>（三） 发起人、拟任负责人受过纪律处分的；</p>
<p>（四） 在申请筹备时弄虚作假的；</p>
<p>（五） 有校规校纪禁止的其他情形的。</p>
<p>第十九条 经批准筹备成立的社团，应当自批准筹备之日起1个月内召开会员大会或者会员代表大会，通过章程，产生执行机构和负责人，并申请成立注册。筹备期间不得开展筹备以外的活动。</p>
<p>第二十条 社团不得刻制公章。社团注册成立后，可向校团委申请，由校学生社团联合会为该社团刻制一个统一规格、统一字样的方形图章，以便开展工作。图章的图样须报校团委备案。社团负责人对图章的保管与使用负有相应的责任。</p>
<h4><p>第四章社团的监督管理</p>
</h4><p>第二十一条 社团开展活动，应当在社团成员内部依照其章程在学校校园内进行。社团活动应当奉行公开原则，出具广告、公告等需要署全名，未经允许，任何社团不得擅用指导部门或其它组织的名义开展活动。社团活动的相关责任和义务由社团和社团负责人自行承担。</p>
<p>第二十二条 社团开展活动，需要提前1周将有指导教师和社团负责人签字并加盖指导单位公章的活动方案提交给校学生社团联合会并报校团委审核备案，校学生社团联合会将在社团网上予以公布。对于不符合学校和社团有关规定的活动，将不予以备案，该活动不得举行。</p>
<p>第二十三条 社团举办重大活动之前，须按规定向指导教师、指导单位和校团委提交申请报告，经初步审核同意后提交一份包括经费预算和安全预案等在内的完整活动方案，经共同批准后方可按规定程序开展活动。社团举办涉外和港澳台活动还须经学校向关主管部门批准。活动结束后，社团负责人必须向指导教师、指导单位和校团委以书面形式进行总结汇报。</p>
<p>第二十四条 社团举办各类出游、社会实践、外出考察等校外活动和具有一定安全风险的活动，必须按《徐州工程学院学生社团举办各类出游、社会实践、外出考察等校外活动安全监督实施细则》（详见该细则）的相关规定，召开活动可行性论证会并办理《安全监督书》；开展出国出境活动，须经学校相关主管部门批准。</p>
<p>第二十五条 社团活动的责任由社团自行承担。社团负责人和骨干成员在活动过程中有重大过错的，其个人须承担相应责任并接受处分。</p>
<p>第二十六条 社团负责人和骨干成员必须接受社团内部成员的监督。社团成员发现社团内部有违法乱纪、徇私舞弊、假公济私等不良行为，可以向校团委、校学生社团联合会举报。</p>
<p>第二十七条 社团创办内部刊物必须遵守相关法律法规和学校规定。内部刊物的编印和发行须经指导教师、指导单位同意后报校学生社团联合会审批。</p>
<p>第二十八条 社团网站（网页、论坛等）必须遵守相关法律法规和学校规定。社团建立网站（网页、论坛等）必须按照校党委宣传部、网络管理中心和校团委的有关规定提交申请报告，经批准后方可着手进行。社团及社团负责人对其网站（网页、论坛等）上的内容负全部责任。</p>
<p>第二十九条 社团有下列情形之一者，由校团委给予警告并责令限期整改，并撤换社团负责人；情节严重的，予以注销登记并追究相关负责人的责任。</p>
<p>（一） 活动范围、内容与社团宗旨、章程不符的；</p>
<p>（二） 拒不接受或者不按照规定接受校团委、校学生社团联合会监督检查的；</p>
<p>（三） 从事营利性的经营活动的；</p>
<p>（四） 侵占、私分、挪用社团资产或者所接受的捐赠、资助的；</p>
<p>（五） 违反规定收取费用、筹集资金或接受、使用捐赠、资助的；</p>
<p>（六） 由于保管不善，导致社团资产严重损失的；</p>
<p>（七） 财务制度混乱的；</p>
<p>（八） 社团执行机构有严重违纪行为的；</p>
<p>（九） 社团成员滥用社团名义进行活动的；</p>
<p>（十） 社团在两个月内未进行活动的；</p>
<p>（十一）有其他违纪行为的。</p>
<p>第三十条 未经批准，擅自开展学生社团的筹备活动，或者未经登记，擅自以学生社团名义进行活动，以及被撤销登记的学生社团继续以学生社团的名义进行活动的，由校团委会同学工部及其他有关部门予以取缔并对相关人员进行相应的处理。 </p>
<h4><p>第五章社团财务</p>
</h4><p>第三十一条 社团经费由各社团自行管理和支配，社团经费必须全部用于社团举办活动所需的各项合理支出。社团的财务工作接受校团委、校学生社团联合会和该社团会员（代表）大会的监督，实行财务公开。社团负责人和财务人员需要定期向校团委和社团会员（代表）大会报告财务工作，社团的年度预决算应当经会员（代表）大会审定。社团成员可对自己认为不合理的财务收支情况提出质疑，社团负责人需要予以准确答复。校团委、校学生社团联合会不定期抽查社团的财务使用情况。</p>
<p>第三十二条 社团的活动经费，原则上自行筹集。校团委对社团举办的具有较高水平、较大影响的活动，以立项审批的方式予以支持。</p>
<p>第三十三条 社团可以通过举办活动寻求校内外单位和个人的经费支持。社团接受的任何捐赠资助，须事先向校团委和校学生社团联合会如实汇报，征得同意方可使用。</p>
<p>第三十四条 社团自成立之始即应建立财务收支账目，账目由社团负责人之外的专人负责，每月须向校学生社团联合会汇报财务支出，每学期向社团成员公布财务支出，接受校团委、校社团联合会、社团成员的监督和审查。</p>
<p>第三十五条 社团应秉承节约原则，合理规划、利用有限的资金组织满足同学需求的社团活动。社团财务人员要切实履行职责。</p>
<p>第三十六条 社团财务记录应力求准确、规范，做到收支明确，票据完整。</p>
<p>第三十七条 社团财产由社团集体占有使用。社团解散，其财产由校团委根据社团章程进行处理。任何人不得侵占、私分或挪用社团的财产，亦不得在社团成员中分配。</p>
<h4><p>第六章 社团的注册、变更与注销</p>
</h4><p>第三十八条 社团注册</p>
<p>社团须在每学期初到校学生社团联合会办理注册，未参加注册的社团不得开展社团活动。</p>
<p>第三十九条 社团变更</p>
<p>社团如需修改章程或变更其他社团登记事项的，应提前7个工作日报批准部门审核备案。</p>
<p>第四十条 社团注销</p>
<p>（一）对于违反国家法律法规及学校管理制度的社团或持续一学期不开展活动的社团，校团委将责令其解散，并追究该社团负责人及相关人员的责任；</p>
<p>（二）会员大会决议解散的；</p>
<p>（三）分立、合并的；</p>
<p>（四）被责令关闭或解散的；</p>
<p>（五）由于其他原因终止的。</p>
<p>第四十一条 社团在提出注销申请后，校团委将对其财务进行审核。审核期间，学生社团不得进行与审核无关的活动。社团应当自审核结束之日起7个工作日内向校团委办理注销登记并向审批部门备案。办理注销登记，应当提交由社团负责人签名、指导教师或指导单位签名盖章并经会员大会通过的《徐州工程学院学生社团注销申请表》。</p>
<h4><p>第七章附则</p>
</h4><p>第四十二条 本章程适用于徐州工程学院校内所有经合法程序审批成立的社团（院级社团由所在学院团委参照本章程给予指导）。凡与本章程相抵触的，以本章程为准。</p>
<p>第四十三条 本章程的解释权在徐州工程学院学生工作管理委员会，校团委可以依据本章程制定具体的管理实施细则。</p>
<p>第四十四条 本章程自公布之日起施行。</p>
<p>（本章程依据教育部《普通高等学校学生管理规定》、民政部《社团登记管理条例》、共青团中央、教育部《关于加强和改进大学生社团工作的意见》及其他相关文件制定。）</p>
<p>徐州工程学院学生工作管理委员会</p>

   
</div>
       
</div>
</form><!--#endeditable-->
						</div>
						<hr>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="bottom">
		<div class="bottom-inner">
			<div class="youqinglianjie">
				<ul>

					<li>友情链接:</li>

					<li><a href="http://www.xzit.edu.cn/">徐工官网</a></li>

					<li><a href="http://gh.xzit.edu.cn/">徐工工会</a></li>

					<li><a href="http://tw.xzit.edu.cn/">徐工团委</a></li>

					<li><a href="http://etc.xzit.edu.cn/">信息化中心</a></li>

					<li><a href="http://hqfwzx.xzit.edu.cn/">后勤服务中</a></li>
					<li><a href="http://jgdw.xzit.edu.cn/">机关党委</a></li>

					<li><a href="http://lib.xzit.edu.cn/">图书馆</a></li>

					<!--#endeditable-->
				</ul>
			</div>
			<div>
				<div class="bottom-logo">
					<img src="<%=request.getContextPath()%>/img/contactus_36.png"
						width="204" height="106" alt="联系我们">
				</div>
				<div class="shutiao"></div>
				<div class="telphone">

					<!-- 版权内容请在本组件"内容配置-版权"处填写 -->
					<ul>
						<li>办公室电话：0516-83105021</li>
						<li>微博:徐州工程学院</li>
						<li>微信公众号:徐州工程学院(微信)号:xzitfwh</li>
					</ul>
					<!--#endeditable-->
				</div>
				<div class="shutiao"></div>
				<div class="telphone">

					<ul class=" list-paddingleft-2">
						<li>
							<p>社团材料邮箱:office@xzit.edu.cn</p>
						</li>
						<li>
							<p>地址：江苏省徐州市云龙区丽水路2号</p>
						</li>
					</ul>
					<p></p>
					<!--#endeditable-->
				</div>
			</div>
		</div>
	</div>

	<!-- 登录模态框（Modal） -->
	<div class="modal  fade" id="mylogin">
		<div class="modal-dialog">
			<div class="modal-content" style="">
				<div class="modal-header">
					<button class="close" data-dismiss="modal" type="button">&times;</button>
					<h4 class="modal-title">
						<label class="label label-danger"
							style="background-color: #9a0e14; border-color: #9a0e14;"><span
							class="glyphicon glyphicon-user">用户登录</span></label>
					</h4>
				</div>
				<div class="modal-body">
					<br /> <br />
					<form role="form" class="form-horizontal" id="loginForm"
						action="/society_server/user/login" method="post">
						<div class="form-group">
							<label for="loginToken" class="col-sm-2 control-label"><span
								class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;账户</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="loginToken"
									name="token" placeholder="请输入您的账户号码/邮箱/手机">
							</div>
						</div>

						<div class="form-group">
							<label for="loginPassword" class="col-sm-2 control-label"><span
								class="glyphicon glyphicon-lock"></span>&nbsp;&nbsp;密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="loginPassword"
									name="password" placeholder="请输入您的密码">
							</div>
						</div>

						<div style="text-align: center;">
							<button type="submit" id="loginBtn" class="btn btn-primary"
								style="width: 350px; background-color: #9a0e14; border-color: #9a0e14; margin-left: 65px;">
								<span class=" glyphicon glyphicon-ok-sign"></span>&nbsp;登录
							</button>
						</div>
					</form>
				</div>
				<br /> <br />
				<div class="modal-footer">
					<div class="container">
						<div class="pull-left">
							<a href="#" title="还没激活账号？赶紧用学号注册吧！" id="registAccount"
								data-dismiss="modal" style="color: #9a0e14;">注册账号</a> <span
								style="margin-left: 120px; color: #9a0e14;">徐州工程学院社团管理平台</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 注册模态框  -->
	<div class="modal  fade" id="registerModal">
		<div class="modal-dialog">
			<form id="registerForm" action="" method=""
				enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title">
							<span class="glyphicon glyphicon-leaf"></span>&nbsp;用户注册
						</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<!-- 
								<div class="form-group">
									<label for="学院"  style="padding-left:10px" 
										class="col-sm-2 control-label mylabStyle">选择学院</label>
									<div class="col-sm-10">
									     <select class="form-control " id="instituteId"
											name="instituteId">
											 <c:forEach var="institute" items="${institutes}">
    										 <option value="${institute.instituteId}">${institute.instituteName}</option>
 										 </c:forEach>
										</select>
									</div>
								</div>
								<br /> <br />
							
						<!-- <div style="display:none;"><input id="courseId" name="courseId" /> </div> -->
								<!--  
								<div class="form-group">
									<label for="班级"  style="padding-left:10px"
										class="col-sm-2 control-label mylabStyle">选择班级</label>
									<div class="col-sm-10">
									     <select class="form-control " id="classId"
											name="class">
											 <c:forEach var="class" items="${classes}">
    										 <option value="${class.classId}">${class.className}</option>
 										 </c:forEach>
										</select>
									</div>
								</div>
								<br /> <br />  -->

								<div class="form-group">
									<label for="studentId"
										class="col-sm-2 control-label mylabStyle">学号</label>
									<div class="col-sm-10">
										<input type="text" style="width: 95%" id="studentId"
											name="studentId" class="form-control" placeholder="请输入学号" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="password" class="col-sm-2 control-label mylabStyle">密码</label>
									<div class="col-sm-10">
										<input type="password" style="width: 95%" id="password"
											name="password" class="form-control" placeholder="请输入密码" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="confirmPassword" style="padding-left: 10px"
										class="col-sm-2 control-label mylabStyle">确认密码</label>
									<div class="col-sm-10">
										<input type="password" style="width: 95%" id="confirmPassword"
											name="confirmPassword" class="form-control"
											placeholder="请再输入密码" />
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button id="registerBtn" type="submit"
							style="background-color: #9a0e14; border-color: #9a0e14;"
							class="btn btn-primary">提交</button>
						<button type="button" id="btnClose" class="btn btn-default"
							data-dismiss="modal">关闭</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>