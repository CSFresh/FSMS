package com.amanda.fsms.constant;

import lombok.Getter;
import lombok.Setter;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CPConstant {
    private List<CPData> cpDataList = new ArrayList<>();

    private List<String> areaList = new ArrayList<>();

    private Map<Integer,List<Integer>> areaToCPMap = new HashMap<>();

    public CPConstant(){
        final AreaEnum[] values = AreaEnum.values();
        for (int i = 0;i<values.length;++i){
            final String area = values[i].getArea();
            areaList.add(area);
        }

        for (int i = 1;i<=17;++i){
            areaToCPMap.put(i,new ArrayList<>());
        }
        areaToCPMap.get(1).addAll(Arrays.asList(2,3,4,5,6,10,11,12,13,14,15,16));
        areaToCPMap.get(2).addAll(Arrays.asList(2,3,4,5,6,7,8,9,10,11,13,14,15,16));
        areaToCPMap.get(3).addAll(Arrays.asList(2,3,4,5,6,11,12,13,14,15,16));
        areaToCPMap.get(4).addAll(Arrays.asList(2,3,4,5,6,7,8,9,10,13,14,15,16));
        areaToCPMap.get(5).addAll(Arrays.asList(2,3,4,5,6,11,12,13,14,15,16));
        areaToCPMap.get(6).addAll(Arrays.asList(2,3,4,5,6,7,13,14,15,16));
        areaToCPMap.get(7).addAll(Arrays.asList(2,5,6,10,11,12,13,14,15,16));
        areaToCPMap.get(8).addAll(Arrays.asList(2,3,4,5,6,7,8,9,10,11,13,14,15,16));
        areaToCPMap.get(9).addAll(Arrays.asList(2,3,4,5,6,7,11,13,14,15,16));
        areaToCPMap.get(10).addAll(Arrays.asList(2,3,4,5,6,11,12,13,14,15,16));
        areaToCPMap.get(11).addAll(Arrays.asList(2,3,4,5,6,7,8,9,10,11,13,14,15,16));
        areaToCPMap.get(12).addAll(Arrays.asList(2,3,4,5,11,12,13,14));
        areaToCPMap.get(13).addAll(Arrays.asList(2,3,4,5,6,11,12,13,14,15,16));
        areaToCPMap.get(14).addAll(Arrays.asList(2,3,4,6,14,15,16));
        areaToCPMap.get(15).addAll(Arrays.asList(2,14,15,16));
        areaToCPMap.get(16).addAll(Arrays.asList(2,3,4,5,14));
        areaToCPMap.get(17).addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19));

        //cp1
        CPData cpData1 = new CPData();
        List<CPDetailScore> cpDetailScoreList = cpData1.getCpDetailScoreList();
        cpDetailScoreList.add(new CPDetailScore("1-1","酒店各部门获得的最新的食品安全体系文件。并组织与其职能相关的培训及采取相应行动以符合最新体系要求。",3, 0,false));
        cpDetailScoreList.add(new CPDetailScore("1-2","酒店应至少有一名由酒店总经理正式任命及通报的食品安全管理人员负责酒店食品安全体系的组织协调工作。",3,0,false));
        cpDetailScoreList.add(new CPDetailScore("1-3","酒店应设置食品安全委员会。\"食品安全委员会组织架构图\"（CP1-R02）及“食品安全委员会清单”（ CP1-R01）应得到总经理的批准且确保当前版本。",0,3,true));
        cpDetailScoreList.add(new CPDetailScore("1-4","各成员应参加每月食品安全委员会会议，总经理至少应每个季度参加一次食品安全会议。保存会议记录（ CP1-R03）。",3,0,false));
        cpDetailScoreList.add(new CPDetailScore("1-5","最少每月进行一次内部检查。检查后采取相应的整改行动。保留相应记录 （纸质或电子记录）。",3,0,false));
        cpDetailScoreList.add(new CPDetailScore("1-6","每半年由拥有合格资质的独立实验室必须进行微生物检测，检测报告显示不合格应彻查原因并建立整改措施，留档，进行重检直至合格。",3,0,false));
        cpDetailScoreList.add(new CPDetailScore("1-7","食源性疾病/食物安全相关投诉报告及调查程序应包含在酒店危机响应计划中。",3,0,false));
        cpDetailScoreList.add(new CPDetailScore("1-8","（HIE:Y/NA）进行了食品安全事故应急(包括上报、调查、相应食品原料追溯、召回）的演练。",1,0,false));
        cpDetailScoreList.add(new CPDetailScore("1-9","所有经食物传播疾病及食物中异物的投诉都要记录在案，并报告给酒店管理层和食品安全委员会。酒店应填写相应报告(CP1-R07)记录事件细节和已采取措施。",3,0,false));
        cpDetailScoreList.add(new CPDetailScore("1-10","涉及媒体披露，政府部门要求或供应商主动召回的商品，应进行召回并退回供应商。使用不合格原辅料制备的食品，或已出现问题的原料、成品均应进行召回。",1,0,false));
        cpDetailScoreList.add(new CPDetailScore("1-11","FSMS记录均按照要求及时填写完整，并且清晰、真实。并需记录人员签字及确认人签字。",3,0,false));
        cpDetailScoreList.add(new CPDetailScore("1-12","与去年审核结果相比，不多于三项的重复发现。",3,0,true));
        cpDetailScoreList.add(new CPDetailScore("1-13","充足的安保措施以确保食品不被人为污染。",3,0,false));
        cpDetailScoreList.add(new CPDetailScore("1-14","审核员到达并通报酒店后应能20分钟内进行审核。酒店委派一名陪同人员进行引路、讲解及记录。酒店方应该将酒店最真实的一面呈现给审核员。",1,0,false));
        cpData1.setCP(1);
        cpDataList.add(cpData1);


        //cp2
        CPData cpData2 = new CPData();
        List<CPDetailScore> cpDetailScoreList2 = cpData2.getCpDetailScoreList();
        cpDetailScoreList2.add(new CPDetailScore("2-1","食品收货、储存、加工、供餐区域内表面（天花、地面、墙壁、下水道、工作台、案板）状态完好，无破损，且易洁防腐。",3,0,false));
        cpDetailScoreList2.add(new CPDetailScore("2-2","烧腊食品制作的各区间分区清晰.",3,0,false));
        cpDetailScoreList2.add(new CPDetailScore("2-3","(HK:NA)裱花间/巧克力间、烧腊熟食间、凉菜间、鱼生间等即食食品制作区应遵从专间设置。",3,0,false));
        cpDetailScoreList2.add(new CPDetailScore("2-4","专间用水、制冰机、可乐机均应配置净水器，最少每月对过滤装置进行冲洗，3~6个月进行过滤装置的更换。",3,0,false));
        cpDetailScoreList2.add(new CPDetailScore("2-5","二次供水系统应定期维护。备有清洗后的检测报告及清洗的记录。二次供水水箱日常应覆盖及上锁。",3,0,false));
        cpDetailScoreList2.add(new CPDetailScore("2-6","加工用水（即厨房或酒吧终端用水），每年至少有一份由当地卫生检验机构或第三方合资质检验机构检验合格的水质报告。",3,0,true));
        cpDetailScoreList2.add(new CPDetailScore("2-7","预防性维保计划应包括加工、储存、陈列、防护、运送、清洁用设备设施及空调通风系统，并有相应的执行记录。",3,0,true));
        cpDetailScoreList2.add(new CPDetailScore("2-8","加工、储存、陈列、保温、运送、清洁用设备设施及空调通风系统均维护良好，且不易产生异物污染。",3,0,false));
        cpDetailScoreList2.add(new CPDetailScore("2-9","食品设备所用润滑剂应为食品级。",1,0,false));
        cpDetailScoreList2.add(new CPDetailScore("2-10","加工、储存、收货区域照明良好，且照明灯有防爆防潮装置。各区域无外露的电线。",1,0,false));
        cpDetailScoreList2.add(new CPDetailScore("2-11","各区域下水道保持畅通",1,0,false));
        cpDetailScoreList2.add(new CPDetailScore("2-12","非紧急维修情况下，不在食品加工过程中进行设备维护保养。",1,0,false));
        cpDetailScoreList2.add(new CPDetailScore("2-13","对于不能维护的设备应搬离食品加工区域，不能移动的设备挂上标签，覆盖保存",1,0,false));
        cpData2.setCP(2);
        cpDataList.add(cpData2);

        //cp3
        CPData cpData3 = new CPData();
        List<CPDetailScore> cpDetailScoreList3 = cpData3.getCpDetailScoreList();
        cpDetailScoreList3.add(new CPDetailScore("3-1","食品及食品相关供应商清单(CP3-R01)应持续更新，易腐食品供应商名单中应至少包括一个备选供应商。供应商名单、证照、资质证明齐全，真实，并在有效期内。供应商资质文件与实际供货相符合。",3,0,false));
        cpDetailScoreList3.add(new CPDetailScore("3-2","酒店应向供应商提出最低食品安全要求，再三违反或抵触酒店要求的供应商应考虑将其撤出供应商名单。",1,0,false));
        cpDetailScoreList3.add(new CPDetailScore("3-3","(HIE:NA)酒店自行制定高风险食品供应商审核计划，全年审核应覆盖所有高风险食品供应商。多酒店联合审核或由一酒店代表审核，亦应有多方确认。",3,0,true));
        cpDetailScoreList3.add(new CPDetailScore("3-4","食品应自至清单内的供应商采购。如果特殊/紧急采购，食品亦应来自有资质的正规渠道，如从超市购买，应保留购物小票。",3,0,false));
        cpDetailScoreList3.add(new CPDetailScore("3-5","(HIE:NA)对于年糕、粽子、月饼等委托加工产品，应提前向供应商要求获取其产品型式检测报告并获得生产厂家标签样式进行内部备案。 ",3,0,false));
        cpData3.setCP(3);
        cpDataList.add(cpData3);


        //cp4
        CPData cpData4 = new CPData();
        List<CPDetailScore> cpDetailScoreList4 = cpData4.getCpDetailScoreList();
        cpDetailScoreList4.add(new CPDetailScore("4-1","收货人员必须接受过相关收货标准的培训，并保持良好的个人卫生。",1,0,false));
        cpDetailScoreList4.add(new CPDetailScore("4-2","收货区干净、无杂物及虫害迹象。区域内设置清洁消毒设施。",3,0,false));
        cpDetailScoreList4.add(new CPDetailScore("4-3","收货区域设置挡雨棚或有其他挡雨措施。",3,0,false));
        cpDetailScoreList4.add(new CPDetailScore("4-4","(HK:NA)磅秤应由官方机构每年一次对其准确性和有效性进行检定。",1,0,false));
        cpDetailScoreList4.add(new CPDetailScore("4-5","收货人员对来货温度、质量、标签、保质期、包装、送货车车辆进行检查并保留记录。",3,0,false));
        cpDetailScoreList4.add(new CPDetailScore("4-6","接收的货品温度符合要求。",3,0,false));
        cpDetailScoreList4.add(new CPDetailScore("4-7","冷藏食品在接收和检查后应立即冷藏储存。易腐食物、高风险食品应优先于低风险食品或干货食品检查入库。",3,0,false));
        cpDetailScoreList4.add(new CPDetailScore("4-8","收货过程中，货物离地置放，且无其他潜在污染的操作。",3,0,false));
        cpDetailScoreList4.add(new CPDetailScore("4-9","收货人员收货前严格索取来货证票。",3,0,true));
        cpDetailScoreList4.add(new CPDetailScore("4-10","收货部应设有鲜蛋清洗消毒设备以确保鲜蛋在储存和加工时不引入交叉污染的风险。（除非酒店有独立的密闭的鲜蛋储存区域或购买经过消毒的鲜蛋）。",3,0,false));
        cpDetailScoreList4.add(new CPDetailScore("4-11","不合格货品进行拒收或退货处理。",1,0,false));
        cpData4.setCP(4);
        cpDataList.add(cpData4);

        //cp5
        CPData cpData5 = new CPData();
        List<CPDetailScore> cpDetailScoreList5 = cpData5.getCpDetailScoreList();
        cpDetailScoreList5.add(new CPDetailScore("5-1","仓管员必须受过培训掌握检查，防损和处理报废食品技能。",1,0,false));
        cpDetailScoreList5.add(new CPDetailScore("5-2","确保货架，地面的干爽及清洁，无锈迹。",1,0,false));
        cpDetailScoreList5.add(new CPDetailScore("5-3","冰箱内不堵塞通风口, 冷藏冷冻设备内无冷凝水或冰晶。冷凝水管接下水管道排放，无破裂。",3,0,false));
        cpDetailScoreList5.add(new CPDetailScore("5-4","食品在适当的温度下存储。预包装食品按商业标签要求的存储条件进行储存。每天进行两次的冰箱冷库的温度监控，并保留CP5-R01记录。",3,0,false));
        cpDetailScoreList5.add(new CPDetailScore("5-5","无过期或变质的食品, 包括膨胀的罐头",3,0,true));
        cpDetailScoreList5.add(new CPDetailScore("5-6","保质期越近的货物靠前存放，保证先进先出",1,0,false));
        cpDetailScoreList5.add(new CPDetailScore("5-7","食物及食品相关物品分类且定位存放，无交叉污染风险。",3,0,false));
        cpDetailScoreList5.add(new CPDetailScore("5-8","储存中无破损包装的食品,包括凹陷的罐头。打开包装的金属罐头也应转移到食品容器内。",1,0,false));
        cpDetailScoreList5.add(new CPDetailScore("5-9","食品储存区域无操作工具、易吸附材质等污染源。",3,0,false));
        cpDetailScoreList5.add(new CPDetailScore("5-10","食品、一次性食品接触用品及化学品均应密闭贮存",3,0,false));
        cpDetailScoreList5.add(new CPDetailScore("5-11","干货库和化学品库保持清洁、干燥、通风。干货储藏温度低于25°C，湿度介于55-65%之间，使用经年检的温/湿度计进行每天一次记录。",1,0,false));
        cpDetailScoreList5.add(new CPDetailScore("5-12","化学品的储存需规范管理",1,0,false));
        cpDetailScoreList5.add(new CPDetailScore("5-13","食品、化学品、操作用具的存放均应离墙离地。",3,0,false));
        cpData5.setCP(5);
        cpDataList.add(cpData5);

        //cp6
        CPData cpData6 = new CPData();
        List<CPDetailScore> cpDetailScoreList6 = cpData6.getCpDetailScoreList();
        cpDetailScoreList6.add(new CPDetailScore("6-1","所有厨房应设立颜色标识系统，包括切板，刀具和食品储存（中转箱）。应对员工进行该系统的培训并签字。",3,0,true));
        cpDetailScoreList6.add(new CPDetailScore("6-2","在食品制备、运送过程中适当防护，不存在被污染的风险。食品制备区域的设备及用具不会带来污染的风险。被污染的食品(包括原辅料)应被丢弃。",3,0,false));
        cpDetailScoreList6.add(new CPDetailScore("6-3","与食品直接接触的容器、包装工具和设备应该使用符合食品安全的材料。",3,0,false));
        cpDetailScoreList6.add(new CPDetailScore("6-4","不同类别食品应分开处理（分开的房间、区域、水池，或在不同时间进行等）",3,0,false));
        cpDetailScoreList6.add(new CPDetailScore("6-5","食品制作专间及专区应规范使用。",3,0,false));
        cpDetailScoreList6.add(new CPDetailScore("6-6","真空包装不用于酒店自制的即食食品。",3,0,false));
        cpDetailScoreList6.add(new CPDetailScore("6-7","应制定标准食谱，包括配料的标准用量。",3,0,false));
        cpDetailScoreList6.add(new CPDetailScore("6-8","常见的易引起食物中毒的原材料应尽量避免使用，或在制备过程中加以控制处理（详见附件1）。不可在食品中添加药品，除非药食同源的物质（详见CP6-R05）。摆盘用花需使用可食用花卉（详见CP6-R05）。不得使用或供应禁用的受保护野生动物。",3,0,false));
        cpDetailScoreList6.add(new CPDetailScore("6-9","有食品添加剂的备案表（CP6-R02），食品添加剂独立专柜上锁存放，按照使用说明正确使用，有使用记录（CP6-R03）用于添加剂称量的电子称应有官方强检报告",3,0,true));
        cpDetailScoreList6.add(new CPDetailScore("6-10","每次制作，应避免大批量高风险食物在室温下长时间存放（持续超过一小时）",3,0,false));
        cpDetailScoreList6.add(new CPDetailScore("6-11","每个餐厅、厨房均配备适量的探针式温度计.探针式温度计，使用前后必须清洁消毒。温度计需定期校准。",1,0,false));
        cpData6.setCP(6);
        cpDataList.add(cpData6);

        //cp7
        CPData cpData7 = new CPData();
        List<CPDetailScore> cpDetailScoreList7 = cpData7.getCpDetailScoreList();
        cpDetailScoreList7.add(new CPDetailScore("7-1","使用正确方法解冻食物。无室温解冻。",3,0,false));
        cpDetailScoreList7.add(new CPDetailScore("7-2","冷藏解冻，解冻食品应在8°C以下0°C以上的冷藏环境中进行。需标贴解冻起始时间。",3,0,false));
        cpDetailScoreList7.add(new CPDetailScore("7-3","冷藏解冻的食物应存放在层架最底层，或指定的独立区域",1,0,false));
        cpDetailScoreList7.add(new CPDetailScore("7-4","冷藏解冻食品时应配置化冻水盘，并经常排水。",1,0,false));
        cpDetailScoreList7.add(new CPDetailScore("7-5","用水的解冻方式应该使用流动水，以确保能清洁表面的污垢残留。",1,0,false));
        cpDetailScoreList7.add(new CPDetailScore("7-6","流水中解冻不应该超过2个小时，解冻现场要张贴解冻标签，标明起始时间。",3,0,false));
        cpDetailScoreList7.add(new CPDetailScore("7-7","解冻后的食品应冷藏储存。从解冻开始计算，食品应在其相应的第二保质期内用完，但流水解冻食品12小时内用完。",3,0,false));
        cpDetailScoreList7.add(new CPDetailScore("7-8","无再次冷冻已解冻过的产品。",3,0,false));
        cpData7.setCP(7);
        cpDataList.add(cpData7);



        //cp8
        CPData cpData8 = new CPData();
        List<CPDetailScore> cpDetailScoreList8 = cpData8.getCpDetailScoreList();
        cpDetailScoreList8.add(new CPDetailScore("8-1","食品烹饪（再加热）温度应该达到摄氏70度以上，至少达到15秒。微波炉加热（再加热）后应停留2分钟。烹饪温度应该监测，并记录。",3,0,true));
        cpDetailScoreList8.add(new CPDetailScore("8-2","(HIE:NA)对于客人要求的非全熟汉堡，应进行记录，或保存点单。",3,0,false));
        cpDetailScoreList8.add(new CPDetailScore("8-3","煎油或榨油呈现澄清状态。",1,0,false));
        cpDetailScoreList8.add(new CPDetailScore("8-4","不能用保温柜或保温水池来加热或翻热食品。",3,0,false));
        cpDetailScoreList8.add(new CPDetailScore("8-5","加热过一次的食品，不能再次加热。",1,0,false));
        cpData8.setCP(8);
        cpDataList.add(cpData8);

        //cp9
        CPData cpData9 = new CPData();
        List<CPDetailScore> cpDetailScoreList9 = cpData9.getCpDetailScoreList();
        cpDetailScoreList9.add(new CPDetailScore("9-1","(HIE:NA)根据食物的类型使用正确的冷却方法，无室温冷却。",3,0,true));
        cpDetailScoreList9.add(new CPDetailScore("9-2","(HIE:NA)烹饪好的食品必须在2小时内冷却至21°C以下，在之后2小时内冷却至8°C以下 。食品应标上日期，说明冷却过程开始的时间。记录到CP9-R01表中。",3,0,false));
        cpDetailScoreList9.add(new CPDetailScore("9-3","自行冷冻食物前，热食冷却必须先符合9-2第一阶段的要求。",3,0,false));
        cpDetailScoreList9.add(new CPDetailScore("9-4","冰浴法降温时，有进行搅拌操作，冰水不能与食品直接接触。",1,0,false));
        cpDetailScoreList9.add(new CPDetailScore("9-5","食品冷却的第一阶段无需覆盖。周围无其他潜在污染。",1,0,false));
        cpData9.setCP(9);
        cpDataList.add(cpData9);


        //cp10
        CPData cpData10 = new CPData();
        List<CPDetailScore> cpDetailScoreList10 = cpData10.getCpDetailScoreList();
        cpDetailScoreList10.add(new CPDetailScore("10-1","高风险冷热食品展示应保持在60°C或以上或8℃以下。供应时段每两小时应进行一次温度监测。记录到CP10-R01食品展示监控记录中。",3,0,false));
        cpDetailScoreList10.add(new CPDetailScore("10-2","(HIE:NA)寿司、海苔卷可以在15°C温度下存放达4小时。温度和时间应记录到CP10-R01食品展示监控记录中。",3,0,false));
        cpDetailScoreList10.add(new CPDetailScore("10-3","如果需要，热食和冷食应该在保温时加以防护。",1,0,false));
        cpDetailScoreList10.add(new CPDetailScore("10-4","食品补给:必须完全替换，在保存2小时内的较先烹饪的食品先被食用。在自助餐台上不能新旧食品混合。",1,0,false));
        cpDetailScoreList10.add(new CPDetailScore("10-5","冰槽内应有排水，冰不可直接与即食食物接触。",1,0,false));
        cpData10.setCP(10);
        cpDataList.add(cpData10);

        //cp11
        CPData cpData11 = new CPData();
        List<CPDetailScore> cpDetailScoreList11 = cpData11.getCpDetailScoreList();
        cpDetailScoreList11.add(new CPDetailScore("11-1","不可在菜单或食品相关宣传上涉及疾病预防、治疗功能方面及其他不实或无证明依据的宣称。",3,0,false));
        cpDetailScoreList11.add(new CPDetailScore("11-2","陈列的食品必须附有名牌。自助餐台名牌上标明食品含有的过敏成分。零点餐牌上应标注过敏原的温馨提示。",3,0,false));
        cpDetailScoreList11.add(new CPDetailScore("11-3","食品的服务中，服务设置应考虑到可能的来自于客人或周围的污染。(HIE:NA)室外自助餐时，所有供应的食品必须被覆盖。",3,0,false));
        cpDetailScoreList11.add(new CPDetailScore("11-4","(HIE:NA)运到客房的食品应保持加盖，避免可能的污染。送餐保温箱应在每次使用后进行彻底清洁消毒。",3,0,false));
        cpDetailScoreList11.add(new CPDetailScore("11-5","后场电梯及餐梯应根据不同用途进行标识。",1,0,false));
        cpDetailScoreList11.add(new CPDetailScore("11-6","(HIE:NA)对于重大聚会或任何100人或以上的宴会，所有食物都要在上菜之前抽取125克样品。样品应密封冷藏48小时。留样的食物应标识并记录在“留样食物清单”，包括留样食品名称，宴会时间，餐厅名称，厨师，留样人签名等。员餐需每餐次每项食品留样。",3,0,false));
        cpDetailScoreList11.add(new CPDetailScore("11-7","(HIE:NA)到会服务，必须进行现场检查并保留检查记录（CP11-R02）。各步骤的温控记录也需要进行。",3,0,false));
        cpDetailScoreList11.add(new CPDetailScore("11-8","主动对消费者进行防止食品浪费提示提醒，引导消费者按需适量点餐。主动告知消费规则和防止食品浪费要求，不得诱导、误导消费者超量点餐。",3,0,false));
        cpDetailScoreList11.add(new CPDetailScore("11-9","(HIE:NA)外卖食品、打包食品或网络订餐食品应标贴外卖标签。",3,0,false));
        cpDetailScoreList11.add(new CPDetailScore("11-10","直接向客人销售或展示的预包装食品，其标签需标准规范。",3,0,false));
        cpDetailScoreList11.add(new CPDetailScore("11-11","对于客人带入酒店的食物，酒店应填写\"食物自带保证表CP11-R03\"",3,0,false));
        cpData11.setCP(11);
        cpDataList.add(cpData11);


        //cp12
        CPData cpData12 = new CPData();
        List<CPDetailScore> cpDetailScoreList12 = cpData12.getCpDetailScoreList();
        cpDetailScoreList12.add(new CPDetailScore("12-1","(HIE:NA)保持酒吧柜台整齐，清洁和消毒。酒吧员工对所在酒吧实行每日检查制度，并如实记录检查结果。",3,0,false));
        cpDetailScoreList12.add(new CPDetailScore("12-2","酒吧内设备清洁状态及运作均维护良好。",3,0,false));
        cpDetailScoreList12.add(new CPDetailScore("12-3","现榨果汁为即时供应。即使存放于8℃或以下，鲜榨果汁不应超过两个小时，切片水果12小时内用完，开封牛奶48小时内用完。",3,0,false));
        cpDetailScoreList12.add(new CPDetailScore("12-4","(HIE:NA)酒吧备有使用绿色砧板、刀具和即弃卫生手套。",3,0,false));
        cpDetailScoreList12.add(new CPDetailScore("12-5","(HIE:NA)备有随手清洁化学品。化学品和咖啡机清洁剂与食品分隔存放。",3,0,false));
        cpData12.setCP(12);
        cpDataList.add(cpData12);

        //cp13
        CPData cpData13 = new CPData();
        List<CPDetailScore> cpDetailScoreList13 = cpData13.getCpDetailScoreList();
        cpDetailScoreList13.add(new CPDetailScore("13-1","日期/时间标签应用于酒店制备的成品/半成品，开封/去除包装食品、食品添加剂、解冻食品和冷却食品。不同用途标签应注明或在样式上有所区分。",3,0,false));
        cpDetailScoreList13.add(new CPDetailScore("13-2","不可在同一食品上张贴相同用途的不同日期的标签。",3,0,false));
        cpDetailScoreList13.add(new CPDetailScore("13-3","标签选用易清除黏胶，或粘贴在保鲜膜上再盖上盖子，以减少标签残留。",1,0,false));
        cpDetailScoreList13.add(new CPDetailScore("13-4","收货时拆卸原外包装纸箱后，内包装上无任何标识的产品，应在内包装上进行标记，对于散装食品，应在储存容器上进行标注。标注信息包括食品名称、生产日期、保质期、生产者名称及联系方式，以便于追溯。",3,0,false));
        cpDetailScoreList13.add(new CPDetailScore("13-5","标注的日期应足以控制食品的先进先出及有效保质期。涉及第二保质期应遵循IHG FSMS设定或生产商说明。 ",3,0,false));
        cpData13.setCP(13);
        cpDataList.add(cpData13);


        //cp14
        CPData cpData14 = new CPData();
        List<CPDetailScore> cpDetailScoreList14 = cpData14.getCpDetailScoreList();
        cpDetailScoreList14.add(new CPDetailScore("14-1","室内环境保持在清洁状态，无杂物，无异味，无积水。",3,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-2","应按区域制定清洁计划表(CP14-R01)，明确划分区域、清洁频率，并每天对清洁结果进行确认检查记录(CP14-R01)。",3,0,true));
        cpDetailScoreList14.add(new CPDetailScore("14-3","食品相关设备及清洁用设备均有具体的清洁流程指引。员工熟悉其岗位相应的设施设备清洁消毒标准操作流程、清洁机器设备和化学品的安全及正确使用流程。",3,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-4","酒店自行对使用布草进行分类。尽量使用纸巾或一次性抹布进行消毒擦拭。不得使用未经消毒的抹布接触已经过清洗的食品接触面或工/用具、制备台面。",1,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-5","清洁过程中应不引起对食品或干净餐厨具的污染。",3,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-6","清洁用具应合理存放以免引起任何污染。",1,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-7","用具、设备包括空调通风、抽油烟系统均相对清洁，无旧的食物残渣、水垢或重油污等。",3,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-8","备用的或清洗好的的餐具正确储存。宴会餐具在使用前必须重新清洗。",3,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-9","制冰机内外均保持清洁状态。 制冰机/冰粒箱应备有冰勺。冰勺应在非使用时浸泡于消毒水内，使用前在清水中进行过水。消毒液每四小时进行更换。制冰机冰勺应是不锈钢材质或不易碎塑料材质，无缺损和锈点。",3,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-10","用于即食的切片机应在连续使用过程中每小时进行清洁消毒。",1,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-11","在洗碗/煲机开始工作时检查主洗和过水温度，且最后过水水温85~90℃。保留CP14-R03洗碗（杯）机温度记录。",3,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-12","(HIE:NA)厨房应有指定清洗厨具区域, 且三槽池正确使用。  ",3,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-13","化学品储存区域和常用区域应配有相应的使用说明和物料安全资料单（MSDS）。",1,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-14","所有化学品包装及分配器上应标有化学品正确的用途名称标签。化学品的使用应遵循化学品标签或供应商的说明，消毒剂需在使用前自行进行浓度检测。",3,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-15","员工有随手清洁的习惯，且随手清洁的工用具及化学品应在现场易于获得。",3,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-16","食品区域内化学品的存放不应产生食品受到污染的风险, 且不可将大量化学品存放于食品区域。",3,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-17","破损餐具应存放在固定容器内。保存破损记录(CP14-R02)。",1,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-18","设置废油桶统一收集用过的废油，而不能直接倒入下水道。废油的转出和处理应根据当地法规交由有资质的承包商进行。",3,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-19","酒店食品制备区域应使用状态良好的脚踏式垃圾桶。食品区域内垃圾桶存放合理，始终盖好，垃圾不过满，桶内垫垃圾袋。垃圾桶每次清空后应进行清洗消毒，并在指定区域进行操作。",3,0,false));
        cpDetailScoreList14.add(new CPDetailScore("14-20","垃圾房内保持整洁，无异味，垃圾分类符合当地法律法规的要求，虫害控制设施到位。垃圾房在不收垃圾时，门保持关闭状态。保留垃圾日清记录CP14-R05。",3,0,false));
        cpData14.setCP(14);
        cpDataList.add(cpData14);


        //cp15
        CPData cpData15 = new CPData();
        List<CPDetailScore> cpDetailScoreList15 = cpData15.getCpDetailScoreList();
        cpDetailScoreList15.add(new CPDetailScore("15-1","酒店食品区域均没有发现显著的老鼠，蟑螂活动的迹象对环境或食物造成污染，如严重的老鼠蟑螂粪便/尿液，啃咬痕迹，死老鼠等，没有聚集式的飞虫活动。",3,0,true));
        cpDetailScoreList15.add(new CPDetailScore("15-2","防虫设备适当设置及安装且运作正常。 ",3,0,false));
        cpDetailScoreList15.add(new CPDetailScore("15-3","有效阻断虫害进入渠道，如适当的纱窗（≥16目） 、塑胶帘、风帘，挡鼠板，及时关门关窗，墙缝、≥6mm的门缝及天花缝隙应及时封堵，下水道出口及排气口设置孔径小于6mm防鼠网。",3,0,false));
        cpDetailScoreList15.add(new CPDetailScore("15-4","酒店应获得虫害服务商及其防治人员的资质。",3,0,false));
        cpDetailScoreList15.add(new CPDetailScore("15-5","有计划地进行虫害控制，并保存虫害控制服务报告或检查报告。虫害控制设施的实际设置与设施布局图相符。",3,0,false));
        cpDetailScoreList15.add(new CPDetailScore("15-6","正确投放及存放杀虫药物和杀虫工具，酒店人员决不可自行使用任何化学性杀虫剂。",3,0,false));
        cpDetailScoreList15.add(new CPDetailScore("15-7","备有杀虫剂清单。虫害防治服务商只能使用经政府部门注册的化学杀虫剂。且杀虫剂的资质文件均在有效期限内。",1,0,false));
        cpDetailScoreList15.add(new CPDetailScore("15-8","在必需进行超低容量空间处理前，应获得服务商的注意事项通知，并遵循执行。确保接班员工获得通知对在进行食品操作前对厨房环境、设备设施进行彻底清洁。酒店临时安排厨房、餐厅、仓储等区域进行喷雾消杀时，负责部门应以书面的方式通知相关部门。",3,0,false));
        cpData15.setCP(15);
        cpDataList.add(cpData15);


        //cp16
        CPData cpData16 = new CPData();
        List<CPDetailScore> cpDetailScoreList16 = cpData16.getCpDetailScoreList();
        cpDetailScoreList16.add(new CPDetailScore("16-1","(HK:NA)在岗的食品从业人员均持有有效健康证。",3,0,true));
        cpDetailScoreList16.add(new CPDetailScore("16-2","进行岗前检查，在岗食品及食品相关人员无易感染或传染病症状。（黄疸、恶心呕吐、腹泻、发烧、咳嗽等）。",3,0,true));
        cpDetailScoreList16.add(new CPDetailScore("16-3","食品及相关员工无明显的皮肤症状（开放性伤口、脓肿、疖子、皮疹等， 无论大小）, 员工手上的微小创伤，必须使用防水并易于识别的创可贴覆盖，然后带上一次性手套。",3,0,false));
        cpDetailScoreList16.add(new CPDetailScore("16-4","酒店向员工提供充足的急救用品。急救用品应经常补充，包括颜色鲜艳的易区分绷带（创可贴）。",3,0,false));
        cpDetailScoreList16.add(new CPDetailScore("16-5","厨房、酒吧、二次更衣间、洗碗间、员工餐厅，收货平台以上区域进口处应配备仅用于洗手的洗手站。且洗手站配备齐全。",3,0,false));
        cpDetailScoreList16.add(new CPDetailScore("16-6","员工养成良好的洗手习惯，例如：在进入厨房时, 处理食物前或处理不同的食品之间, 接触任何污染源后。员工以正确的步骤彻底清洗双手。",3,0,false));
        cpDetailScoreList16.add(new CPDetailScore("16-7","制备即食食品时、接触干净器具或餐具的食品接触面时应佩戴一次性手套或使用工具。",3,0,false));
        cpDetailScoreList16.add(new CPDetailScore("16-8","员工工服由制服房统一管理。食品区域用布草（不同功能及使用区域）和厨衣从收集到发放均分类处理。",1,0,false));
        cpDetailScoreList16.add(new CPDetailScore("16-9","后场区域张贴食品及食品相关人员仪容仪表示例，相关员工遵循标准。所有进入加工区域的人员均需符合个人卫生要求（白大褂、帽子及鞋套），包括厨房以外的工作人员、供应商、参观检查人员、维保人员、服务商。",3,0,false));
        cpDetailScoreList16.add(new CPDetailScore("16-10","专间内制备熟食时应佩戴口罩，或根据当地监督部门要求正确使用口罩。",3,0,false));
        cpDetailScoreList16.add(new CPDetailScore("16-11","个人物品，包括衣服、财物等不应存放于食品制备附近的区域。私人水杯统一存放，且水杯为非易碎材质，并带盖。",3,0,false));
        cpDetailScoreList16.add(new CPDetailScore("16-12","任何污染食品的行为均禁止。",3,0,false));
        cpDetailScoreList16.add(new CPDetailScore("16-13","应有正确的试味程序。",3,0,false));
        cpDetailScoreList16.add(new CPDetailScore("16-14","员工更衣室和洗手间应保持良好清洁状态，设有效排气装置。食品区域同楼层的员工洗手间内洗手池配备要求与厨房内洗手池配备相同。",1,0,false));
        cpDetailScoreList16.add(new CPDetailScore("16-15","（疫情时）酒店收货区域及员工入口处，应配备红外线温度计监测来供货人员及来访者体温。",1,0,false));
        cpData16.setCP(16);
        cpDataList.add(cpData16);

        //cp17
        CPData cpData17 = new CPData();
        List<CPDetailScore> cpDetailScoreList17 = cpData17.getCpDetailScoreList();
        cpDetailScoreList17.add(new CPDetailScore("17-1","酒店至少有一名食品安全培训员实施培训策划或直接实施食品安全相关培训工作。",3,0,false));
        cpDetailScoreList17.add(new CPDetailScore("17-2","年度、月度培训计划中应包括食品安全相关类别培训内容。 重点部门员工（厨房，餐饮部等）每年至少有二次再培训。其他部门每年至少有一次培训。",3,0,false));
        cpDetailScoreList17.add(new CPDetailScore("17-3","培训部人员负责监督各部门食品安全培训的执行情况，并在FSMS会议中进行通报。",1,0,false));
        cpDetailScoreList17.add(new CPDetailScore("17-4","所有新员工应该接受基于FSMS体系的食品安全知识，人员规范和法规的培训。",3,0,false));
        cpDetailScoreList17.add(new CPDetailScore("17-5","员工熟悉岗位上的食品安全要求及相关的基本食品安全知识。",3,0,false));
        cpDetailScoreList17.add(new CPDetailScore("17-6","保存员工的培训记录、考试记录及培训证书复印件或扫描件。",1,0,false));
        cpDetailScoreList17.add(new CPDetailScore("17-7","每位员工应该接受有关2018《餐饮服务食品安全操作规范》和2019《食品安全法实施条例》的培训和指导，并同意在今后的工作中遵守相关原则。保留培训记录。",1,0,false));
        cpData17.setCP(17);
        cpDataList.add(cpData17);

        //cp18
        CPData cpData18 = new CPData();
        List<CPDetailScore> cpDetailScoreList18 = cpData18.getCpDetailScoreList();
        cpDetailScoreList18.add(new CPDetailScore("18-1","酒店餐饮服务许可证服务范围与实际经营范围相符。 ",3,0,true));
        cpDetailScoreList18.add(new CPDetailScore("18-2","搜集并更新适用的法规清单（CP18-R01）。",1,0,false));
        cpDetailScoreList18.add(new CPDetailScore("18-3","法规内容涉及部门应证明已知悉并执行相关法规要求。",3,0,false));
        cpDetailScoreList18.add(new CPDetailScore("18-4","搜集相关社会资讯，留档，并通知相应部门。",3,0,false));
        cpDetailScoreList18.add(new CPDetailScore("18-5","酒店范围内设置了专区或沟通流程以及时将食品安全信息传达给员工。",1,0,false));
        cpData18.setCP(18);
        cpDataList.add(cpData18);

        //cp19
        CPData cpData19 = new CPData();
        List<CPDetailScore> cpDetailScoreList19 = cpData19.getCpDetailScoreList();
        cpDetailScoreList19.add(new CPDetailScore("19-1","列出外包服务清单（CP19-R01）。",3,0,true));
        cpDetailScoreList19.add(new CPDetailScore("19-2","所有外包服务商应获得相应的政府许可资质。",3,0,true));
        cpDetailScoreList19.add(new CPDetailScore("19-3","属于外包的维护保养或特殊设备清洁服务应保留其服务报告。",3,0,true));
        cpDetailScoreList19.add(new CPDetailScore("19-4","对于酒店有权责进行监督管理的外包餐厅，酒店方应和外包餐厅拟定双方的食品安全责任。",3,0,true));
        cpDetailScoreList19.add(new CPDetailScore("19-5","自动售卖机应有规范管理。",1,0,true));
        cpData19.setCP(19);
        cpDataList.add(cpData19);
    }
}