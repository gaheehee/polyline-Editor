# polyline-Editor 프로그램 간단한 사용 설명

<br>

+ 화면에 클릭하면 점 생성  
+ 또 다시 클릭하면 점이 또 생성되고 이전에 생성된 점과 이어지는 선 생성  
+ closed 버튼 클릭 시, 이어지지 않은 점들 사이에 선이 생성되어 도형 생성  
+ 이미 존재하는 점 클릭 후 드래그 시, 원하는 곳으로 점 위치 변경 가능  
+ clear 버튼 클릭 시, 화면이 cleare.

# polyline-Editor 코드 설명

<br>

+ PolylineEditor: 메인 클래스로 JFrame 생성과 MyDrawPanel, JButton
등 배치함  
+ Polyline: 폴리라인을 정보를 가지고 있는 클래스. 폴리라인을 구성  
하는 점들을 ArrayList로 저장하고 있고, 마우스 이벤트를 처리할
수 있도록 MouseAdpater의 subclass로 정의함  
+ MyDrawPanel: Polyline객체를 그림. Polyline객체를 MouseListener
로 등록함  
+ Clear 버튼을 누르면 polyline clear됨  
+ Polyline 클래스에 mouseDragged()를 구현하여 꼭지점을 수정 가능하도록 함  
+ 마우스 움직임 이벤트를 받기 위해 Polyline을 MouseMotionListener로 MyDrawPanel에 등록함  
+ “Clear” 버튼 옆에 “Closed” 버튼을 추가하여 Polyline의 경로를
닫아 Polygon으로 만들어 준다.
