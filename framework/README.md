# Внешний тренинг компании EPAM 
# Итоговый фреймворк
  
Задача - построить фреймворк для автоматизации Hardcore задания из курса WebDriver.

Что должно быть в итоговом фреймворке:

1. webdrivermanager для управления коннекторам к браузерам
2. Page Object / Page Factory для абстракций страниц
3. Модель для бизнес-объектов необходимых сущностей
4. properties файлы с тестовыми данным для разных окружений (как минимум 2)
5. xml suites для smoke тестов и всех тестов
6. При падении теста должен быть сделан скриншот с датой и временем
7. Фреймворк должен иметь возможность запуска с Jenkins и параметризацией браузера, тест suite, environment. Результаты тестов должны быть на графике джобы, скриншоты должны быть заархивированны как артефакты   

скрипт для запуска из терминала windows:

mvn -Dbrowser=chrome -Denvironment=dev clean test

для запуска с другим браузером использовать:
mvn -Dbrowser=firefox -Denvironment=dev clean test

Запуск через xml конфигурацию:
mvn -Dbrowser=chrome -Denvironment=dev -Dsurefire.suiteXmlFiles=src\test\resources\testing-smoke.xml clean test

для запуска с другими параметрами (будет падение теста):
mvn -Dbrowser=chrome -Denvironment=qafail

Скриншот в случае падения теста будет сохранен в директории target

Скриншоты работы фреймворка:
* passed tests:
![тесты пройдены](img/console-ok.jpg)    
![тесты пройдены. репорт 1](img/TestNgReport1.jpg)   
![тесты пройдены репорт 2](img/TestNgReport2.jpg)
![тесты пройдены репорт 3](img/TestNgReport3.jpg)   
* failed tests: 
![тест провален](img/console-not-ok.jpg)
![тест провален](img/TestFalureScreenshot1.jpg)
![провал теста сам скриншот, сгенерированный фреймворком](img/screenshots2021-12-13_17-56-18.png)







