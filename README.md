# Text-RPG

## 0. 개요
텍스트 RPG 게임이다. 

검은 화면에 하얀 글자로 데이터를 표현한다. 플레이어는 8개의 상태를 가지며, 게임을 진행하면서 몬스터를 사냥한다. 사냥을 하면 골드와 경험치를 얻고, 경험치를 모아 레벨업을 하여 능력치를 상승시킬 수 있다. 골드로 상점에서 아이템을 살 수 있으며, 보스 몬스터를 3마리 잡을 경우 게임이 종료된다. 몬스터에게 사망할 경우 부활할 수 있으나, 처음부터 다시 시작해야 한다.
## 1. 실행화면
<img src="/img/img1.png" width="100%" height="100%">
<img src="/img/img2.png" width="100%" height="100%">
<img src="/img/img3.png" width="100%" height="100%">
<img src="/img/img4.png" width="100%" height="100%">
<img src="/img/img5.png" width="100%" height="100%">

## 2. 플로우차트
![flowchart](img/Flowchart.PNG)




## 3. 구성
![function](./img/Function.PNG)
Hunt 안에 존재하는 메인 함수에서 프로그램이 구동된다. main 함수 안에는 while(1)문이 존재하며, 조건을 달성할 때까지 내장된 기능을 반복한다. 플로우차트에서 본 것처럼, 사용자의 입력에 따라 여러가지 행동을 할 수 있다.


## 4. 프로그램 코드
```java
int[][][] User =  {{{20, 2, 2, 3, 1,20,0,1}/*
				[0][0][0] : Health
				[0][0][1] : Attack
				[0][0][2] : Armor
				[0][0][3] : Luck
				[0][0][4] : Exp
				[0][0][5] : MaxHealth
				[0][0][6] : Gold
				[0][0][7] : Level

		*/,{0,0,3,0,0,0,0,0,-1000},{0,0,2,0,0,0,0,0,-2000},{0,0,2,0,0,0,0,0,-3000},{0,0,2,0,0,0,0,0,-4000},{0,9,0,0,0,0,0,0,-5000},/*
		     [0][1] : Helmet              [0][2] : Overwear	  [0][3] : Overwear	        [0][4] : Shoes	               [0][5] : Weapon
						## 마지막 숫자는 무기 이름
		
		*/{0,0,0,0,0,0,0,0}},/*
		   [0][6] :	FinalStatus
		
		 
		*/{{3,0,0,0,0}}};
		// [1][0][0] : Potion
```
플레이어의 상태는 3차원 배열 내에 저장된다. 기본 능력치와 장비 능력치와 합산되어 최종 능력치가 정해진다.
```java
while(true)
		{	
			System.arraycopy(ApplyStatus(User), 0, User,0,User.length);			
			
			System.out.printf("   -- Status --                 -- Equipment --\n");
			System.out.printf("   이름  :  %-16s   투구  : %s (방어 + %d)\n", Name, Index(User[0][1][8]), User[0][1][2]);
			System.out.printf("   LV    :  %-16d   상의  : %s (방어 + %d)\n", User[0][6][7], Index(User[0][2][8]), User[0][2][2]);
			System.out.printf("   체력  :  %-3d/%-12d   하의  : %s (방어 + %d)\n", User[0][6][0],User[0][6][5],Index(User[0][3][8]), User[0][3][2]);
			System.out.printf("   공격  :  %-16d   신발  : %s (방어 + %d)\n", User[0][6][1], Index(User[0][4][8]), User[0][4][2]);
			System.out.printf("   방어  :  %-16d   무기  : %s (공격 + %d)\n", User[0][6][2], Index(User[0][5][8]), User[0][5][1]);
			System.out.printf("   행운  :  %-16d\n", User[0][6][3]);
			System.out.printf("   경험  :  %-3d/%-16d\n", User[0][6][4], pibonachi(User[0][0][7]));
			System.out.printf("   골드  :  %-16d\n\n\n", User[0][6][6]);


			System.arraycopy(Move(User), 0 , User, 0, User.length);
			Thread.sleep(1000);
			System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
			
			if (User[0][6][0] <= 0)
			{
				System.out.print("\n\nYOU");
				Thread.sleep(1000);				
				System.out.print(" DIED");
				Thread.sleep(2000);

				System.out.println("\n\n\n\n부활하시겠습니까? 예:1, 아니오:2");
				if (1 == input.nextInt())
				{
					System.arraycopy(Reseraction(),0,User,0,Reseraction().length);
					User[0][0][0] = 20;
					User[0][0][5] = 20;
					Travel = 0;
					Finish = 0;

					DotLine();
					continue;
				}
				else
				{
					System.out.print("\n\n\nGame Over\n\n\n");
					Thread.sleep(2000);
					break;
				}
			}
		}
	}
```
while문 안에서 상태를 표시하고 루프를 반복할 때마다 체력을 확인하여 사망정보를 처리한다.
```java
int a = rd.nextInt(4);
		Scanner input = new Scanner(System.in);
		System.out.println("\n당신은 갈림길에 마주했습니다. 어디로 가시겠습니까?\n");
			
		if (a==0)
		{
			System.out.println("  ▲     왼쪽 : 1,  앞 : 2, 오른쪽 : 3\n◀□▶");
			while(true)
			{
				String i =input.nextLine();
				if (i.equals("1") || i.equals("2") || i.equals("3")) break;
				else System.out.println("\n갈 수 없는 방향입니다.\n");
			}
		}	
```
가는 길을 선택할 수 있다.
```java
public static int[][][] Accident(int[][][] User) throws InterruptedException, IOException
	{
		Event event = new Event();
		Fight fight = new Fight();
		Random rd = new Random();	
		Boss boss = new Boss();
		
		Scanner input = new Scanner(System.in);

		if (User[0][0][7] > Finish*3+5  && (int)(rd.nextFloat()*User[0][0][7]*Travel/2) < Travel)
		{
			System.arraycopy(boss.MetBoss(User), 0 ,User, 0, User.length);
			Finish = boss.BossEncounter;
		}
		else
		{
			int a = rd.nextInt(2);
			if (a == 0)
			{
			System.arraycopy(fight.MetMonster(User), 0 ,User, 0, User.length);			
			}
			else if (a == 1)
			{
			System.arraycopy(event.MetEvent(User), 0 ,User , 0, User.length);				
			}
		}
		return User;
	}
```
무작위 혹은 사용자의 상태에 따라 몬스터를 만나거나 이벤트가 발생한다.
```java

	public static int[][][] Shop(int[][][] User) throws InterruptedException, IOException
	{
		DotLine();
		Scanner input = new Scanner(System.in);

		while(true)
		{	
			int j; int HowMany;			
			
			System.out.println("\n\n무엇을 사시겠습니까?");
			System.out.println("0. 먹거리\n1. 투구\n2. 상의\n3. 하의\n4. 신발\n5. 무기\n6. 상점 주인과 대화\n7. 나간다");
			int  i = input.nextInt();
		
    // 이하 생략 //
    
		}	
		return User;
	}
```
상점에서 아이템을 구매할 수 있다.
```java
static int[] Status = {0,0,0,0,0,0,0,0};
static String MonsterName = "";

Fight(int a, int b, int c, int d, int e, int f, int g, int h, String Name)
	{
		Status[0] = a; // 체력
		Status[1] = b; // 공격
		Status[2] = c; // 방어
		Status[3] = d; // 행운
		Status[4] = e; // 경험
		Status[5] = f; // 최대체력
		Status[6] = g; // 골드
		Status[7] = h; // 레벨
		MonsterName = Name;
		
	}
  
public static int[][][] MetMonster(int [][][] User) throws InterruptedException, IOException
	{
		Random rd = new Random();
		
		int value = rd.nextInt(44) + 1;

		if (value == 1)
		{
			Fight a1 = new Fight(2, 3, 2, 1,10,0,20,1, "꿀같은 점심시간");
			System.arraycopy(a1.Battle(User),0,User,0,User.length);			
      
    // 이하 생략 //
  }
```
몬스터를 만난다. 몬스터는 fight 클래스의 object이다. 수치를 변경하여 다양한 몬스터를 만들 수 있다.
