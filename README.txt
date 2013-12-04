*** Nhom 10 - QLQTPM - DH KHTN ***

.Nhung tinh nang da dat duoc:
- Hien thi chi tiet ban do
- Danh dau dia diem hien tai cua nguoi su dung thong qua GPS
- Nguoi dung co the xem cac hinh anh dac trung trong muc (Pictures)
- Tao menu cho nguoi dung chon cac chuc nang chinh

.Cach build chtrinh
- Chuan bi cac file can thiet:
    Download cac file .json, .map tu dropbox va luu lai vao trong SD Card
cua dt (Luu trong thu muc goc cua dt, k luu vao bat ki thu muc nao #)
- Download project -> import project vao eclipse -> Run project 
Note: Neu qua trinh build xay ra loi, kiem~ tra lai xem library Sliding Menu
da duoc add vao project hay chua (right click project -> properties 
-> chon the Android -> ben phai trong muc Library -> kt neu co check
la ok -> chua co thi add library trong thu muc libs cung` vs project - ten
thu muc la 'library') 
-> Sau cung run project kt (Do Emulator - may gia lap tren eclipse k co
tinh nang GPS nen viec su dung show vtri hien tai ng dung chi thuc thi 
dc tren may that).

.Nhung chuc nang can thuc hien:
- Liet ke nhung muc thu hut cua ung dung (Food, restaurant, school, hotel,..)
- Chuc nang lien quan toi ban do. Khi nguoi dung chon bat ki 1 vtri nao tren
ban do, neu vtri dc chon co chua thong tin thi show ra cho ng dung` (o~
dang. popup tu` duoi truot len show thong tin lien quan nhu ten, dchi, loai,
...).
- Tinh nang cho phep ng dung danh dau ngau nhien 1 vtri nao do tren ban do.
- Tinh nang ghi chu ve vtri bat ki
- Tinh nang xem lai thong tin ng dung da~ bookmark. Khi click 1 item trong 
bookmark list thi show vtri do len lai tren ban do
- Tinh nang publish thong tin len fb
- Hien thi thong tin Wiki (Cac thong tin wiki dac trung da co - tren dropbox)

.Can thuc hien truoc mat':
- Vi tat ca du lieu lien wan toi map nhu thong tin cac POIs, thong tin 
nha hang, hotel, parking, food, places,... deu nam trong file HCMTour.json.
Nen can phat doc va parse data tu file nay vao app (dung` GSON library de
parse) va luu vao List<?>. Mo ta: khi nguoi dung chon bat ki diem nao tren 
ban do -> bat su kien onTouchListening() de lang nge -> nguoi dung cho vtri
nao thi se co kinh do + vi do tuong ung (Lattitude, Longtitude) -> Tu toa
do nay so sanh vs data parse ra duoc tu file json (Data tu .json bo vao` 
List<?>) muc "coordinates": ... Neu trung cai nao thi lay thong tin
"properties": ... liet ke cho nguoi dung thay + co kem them ghi chu va 
bookmark.

.Mo ta cau truc file .json:

{"type": "FeatureCollection",

"features": [
{"type": "Feature",
	
	"properties": {
		
		"name:en": "Fuel Retailer Agent - Shop 7A",

		"name": "Dai Ly Ban Le Xang Dau - Cua Hang 7A",

		"amenity": "fuel",
		
		"operator": "Petrolimex"
	
	},
	
	"geometry": {"type": "Point", "coordinates": [106.7069453, 10.7660058]}},

{"type": "Feature",
	
	"properties": {
		
		"name": "Techcombank",
		
		"amenity": "atm"
	
	},
	"geometry": {"type": "Point", "coordinates": [106.7463525, 10.8409087]}},

....
....
  ]
}

.Cau truc file json nhu tren, sau attributes "features": [ la array cac 
records. Moi record tuong ung vs cac truong "type", "properties" va
"geometry". Nhung thong tin wan trong can lay la: "properties", 
"geometry" -> "coordinates"

.Thu vien dung`:
OpenStreetMap + JOSM (Java OpenStreetMap Editor - dung de lay mot vung ban
do offline duoi dang .osm extension -> convert qua file .map de su dung 
trong app).
Dung JOSM de tao file json tu file osm luon
Su dung thu vien sliding menu + mapsforge (hien thi map offline len man hinh)

.Link download cac file can thiet:
    https://www.dropbox.com/sh/kkyy5dcztkko6ym/tR9hS1ju_W