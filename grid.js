Ext.onReady(function() 
{	
	var store = new Ext.data.Store(
	{
		fields:['statisticsItem', 'statistic'],
		proxy:{
			type:'ajax',
			url:'servlet/StatisticsInfoService',
			reader:{
				type:'json'
			}
		},
		autoLoad: true
	});
	
	var grid = new Ext.grid.GridPanel(
	{
		renderTo: Ext.getBody(),
		width: 500,
		height: 500,
		store:store,
		columns:[
            {header:"统计项", dataIndex:"statisticsItem"},
            {header:"统计值", dataIndex:"statistic"}         
		],
		bbar:new Ext.PagingToolbar({
			pageSize:25,
			store:store,
			displayInfo:true,
			displayMsg:'显示第{0}条到{1}条记录，一共{2}条',
			emptyMsg:"没有记录"
		})
	});
});
