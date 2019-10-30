  select   demand.componentnaming ,stock.componentmodel , demand.backplane,stock.backplanetype,
   demand.backpanelcolor,stock.backpanelcolor,
   demand.junctionboxLength,stock.linelength,
   demand.junctionbox,stock.junctionboxtype
  from  sys_customers_demand as demand, sys_stock_quantity as stock where
      stock.is_deleted=0 and  demand.is_deleted=0 