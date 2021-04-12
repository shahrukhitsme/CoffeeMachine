Provide input in input.txt file. <br />
First line has the number of test cases (Test Cases: 4)<br />
Then there will be blocks of lines for each test case<br />
In each block:<br />
In the first line, specify the number of outlets in the coffee machine (Number of Outlets: 4)<br />
Next line will have the number of stocks (Items in Stock: 5)<br />
Followed by all those stocks, stock_name: stock_quantity (hot_water: 500)<br />
After that provide number of beverage request (Number of beverage requests: 4)<br />
Followed by that many requests<br />
Each request in 2 lines, first line telling which outlet (Outlet: 1) and second line telling which drink (Drink: Coffee)<br />


Example:<br />
Test Cases: 2<br />
Number of Outlets: 4<br />
Items in Stock: 5<br />
hot_water: 500<br />
hot_milk: 500<br />
ginger_syrup: 100<br />
sugar_syrup: 100<br />
tea_leaves_syrup: 100<br />
Number of beverage requests: 4<br />
Outlet: 1<br />
Drink: Coffee<br />
Outlet: 2<br />
Drink: Green Tea<br />
Outlet: 3<br />
Drink: Tea<br />
Outlet: 1<br />
Drink: Coffee<br />
Number of Outlets: 4<br />
Items in Stock: 5<br />
hot_water: 500<br />
hot_milk: 500<br />
ginger_syrup: 100<br />
sugar_syrup: 100<br />
tea_leaves_syrup: 100<br />
Number of beverage requests: 4<br />
Outlet: 1<br />
Drink: Coffee<br />
Outlet: 2<br />
Drink: Green Tea<br />
Outlet: 3<br />
Drink: Tea<br />
Outlet: 1<br />
Drink: Coffee<br />

Supported items: hot_water | hot_milk | ginger_syrup | sugar_syrup | tea_leaves_syrup | green_mixture<br />
Supported drinks: Coffee | Tea | Green Tea | Black Tea<br />

To add more items or drinks, add its class and update switch case in CoffeeMachine.java
