# answer-contest
答题竞赛

服务端使用:spring boot  mybatis  org.mybatis.generator  lombok插件
页面使用原生JS

功能描述:

竞赛: 1、	以一小时为限或全部小组结束答题时结束，按用时时间最短排名颁奖；
      2、	时间一样的，跨部门（含二级部门）小组优胜； 
      3、	界面每次只显示一题，答对才能看到下一题；答错时，提示答错，冷却时间15秒，才能再次答题，直到答对为止；
      
投票: 以小组为单位投票，每个小组1票，本中心/组织的小组不得投本中心。
