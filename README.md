# Java_Learning  
This repository is mainly for java learning within 6 months(2025.3.1~2025.8.1). By the end of this semester, the following targets must be achieved!  

## Learning Progress  
- [ ]  **(3月)**: 完成 Java 語法、I/O、HttpClient 學習，實現輸入/調用初版代碼。  
- [ ]  **(4月)**: 添加 SQLite 數據庫，實現歷史查詢功能(JDBC 連接)。  
- [ ]  **(5月)**: 多線程支持，允許多用戶同時問答。調用 Hugging Face API（Flask 部署）  
- [ ]  **(6月)**: 使用 Spring Boot，將功能打包成 RESTful API  
- [ ]  **(7-8月)**:添加情感分析模塊，優化性能，完成報告  


## Closing Project(Java AI 助手（NLP 小模型調用）)  
功能描述：  
1. 用户输入问题 -> 調用 NLP 接口 -> 返回答案
2. 記錄問答歷史到 SQLite 數據庫
3. 支持簡單的情感分析功能

模块分析：
1. **用戶請求模塊**：Console 輸入或簡易 Web API 輸入
2. **NLP 調用模塊**：使用 `HttpClient` 調用 Flask API
3. **結果存儲模塊**：使用 JDBC 將問答結果存入 SQLite 數據庫
4. **情感分析模塊**：使用簡單 NLP API 返回情感指標（正/負/中性）

进度表：
- [ ]  **Module 1 (3月)**: 基礎 Java + NLP 調用
- [ ]  **Module 2 (4月)**: 數據庫記錄
- [ ]  **Module 3 (5月)**: 多線程並發
- [ ]  **Module 4 (6月)**: API 化與部署
- [ ]  **Module 5 (7-8月)**: 優化 & 完成報告
