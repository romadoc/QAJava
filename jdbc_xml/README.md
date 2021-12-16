# JDBS + XML
## Задание: Реализовать архитектуру для работы с БД и XML файлом   

## Требования:  
* Валидация XML файла с помощью XSD файла   
* Архитектура должна позволять добавлять товар   
* Просмотр товаров всех типов   
* Просмотр краткого списка всех товаров   
* Просмотр краткого списка товаров определенного типа   
* Детальный просмотр выбранного товара   
* Добавление товара в корзину   
* Просмотр корзины   
* Удаление одного элемента из корзины   
* Тестирование   

## Структура
Структура проекта представлена пакетом, где располагаются источники данных [datasource](datasource),
внутри которой находятся файл xml [carShop.xml](datasource/carShop.xml) и файл базы данных [shopDB](datasource/shopDB.db).  
Там же расположен файл [schema.xsd](datasource/schema.xsd).   

Структура самого приложения.   
В корне находятся два пакета [main/java](src/main/java) и [test](src/test/java) .
В пакете main располагаются пакеты с классами, отвечающие за реализацию функционала приложения:   

[actionimpl](src/main/java/actionsimpl) - содержит классы интерфейсов   
[buisneslayer](src/main/java/buisneslayer) - содержит классы, реализующие функционал приложения
[connectors](src/main/java/connectors) - содержат классы, обеспечивающие связь приложения с источниками данных   
[models](src/main/java/models) - пакет, содержащий модели
[parsers](src/main/java/parsers) - парсеры, обеспечивающие чтение/запись xml файла

Структура пакета [test/java](src/test/java)   

В данном пакете располагаются классы, обеспечивающие тестирование функционала приложения   

[Базовый тест, BaseTest](src/test/java/BaseTest.java)   

[TestAddCarToChart (тест добавления в корзину) ](src/test/java/TestAddCarToChart.java)   

[TestOfAdding (тест возможности добавления сущности) ](src/test/java/TestOfAdding.java)      

[TestRemoveFromChart (тест возможности удаления из корзины) ](src/test/java/TestRemoveFromCart.java)   

[TestViewCarByType (тест возможности просмотра) ](src/test/java/TestViewCarByType.java)   

[TestViewCarInDetail (тест возможности детализированного просмотра) ](src/test/java/TestViewCarInDetail.java)   

[TestViewCars (тест возможности просмотра всех категорий) ](src/test/java/TestViewCars.java)   

[TestViewCart (тест возможности просмотра содержимого корзины) ](src/test/java/TestViewCart.java)







