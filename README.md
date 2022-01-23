นายณัฏฐกฤตย์ คงแก้ว 6210612849 
สำหรับgit hubนี้เอาไว้ส่งงาน cn332 ปีการศึกษา2/256 คณะวิศวะกรรมศาสตร์ มหาลัย ธรรมศาสตร์ รังสิต
สำหรับงานนี ผมได้ใช้ MYSQL ในการเปิดdatabase ซึ่ง มันเป็นเซิร์ฟเวอร์ ดังนั้นผู้จะเปิดต้องเอาไฟล์ หรือcsvไปเปิดในmysqlของตนเอง
ผมได้ตั่งชื่อfile ในmysqlว่า database:"drawing"เเละใช้table จาก "SELECT * FROM drawing.drawing_database_real_csv
สำหรับข้อมูลที่ใช้ผมใช้ข้อมูล6หมวดหมู่ก็คือ
int number =  ไว้เรียงลำดับเเละเเยกจำนวนข้อมูล จะได้เเยกง่ายๆ
char shape = เเบ่งไป3อย่างคือ rectangle circle trinagle
char size = เเบ่งขนาดไว้3ขนาดคือ small medium large (ยังเพิ่มไม่ได้ในอนาคต)
char color = สีภายในรูป (เพิ่มได้ในอนาคต)
int position_x = positionที่จะเซ้ทในเเกนx 
int position_y = positionที่จะเซ็ทในเเกนy
ซึ่งในที่นี้ก็ทำข้อมูลในdatabase มีอยู่3อย่าง
1 rectangle small red 10 10
2 circle medium blue 10 50 
3 triangle large yellow 50 20 
เเละในlib มีตัว mysql-java-connect8.0.1 เพื่อเชื่อมmysqlกับ java เป็นตัวช่วยในการใช้jdbc driver