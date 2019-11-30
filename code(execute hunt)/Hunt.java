import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Hunt
{
	static int lightening=0;//벼락
	static int key=0;//호반우의 황금열쇠
	static boolean floor2 = false;//2층 올라가기

	static String Name = "";
	static int Travel = 0;
	static int Finish = 0;


	public static void main(String args[]) throws InterruptedException, IOException
	{
		Random rd = new Random();	
		Scanner input = new Scanner(System.in);

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
		
		Name = Intro();

		DotLine();

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

			if (lightening==1)
			{
				Thread.sleep(800);
				System.out.println("\n\n벼락을 맞았다! 체력이 감소합니다.(-20)\n\n");
				lightening = 0;
				Thread.sleep(800);
				User[0][0][0]-=20;
			}

			if (Finish == 3)
			{	DotLine();
				Thread.sleep(1500);
				System.out.println("\n\nGame Clear!\n\n");	
				Thread.sleep(1500);
				System.out.println("\n\n플레이해주셔서 감사합니다.\n\n");
				Thread.sleep(1500);
				System.out.println("\n\n-- 제작진 --\n\n");
				Thread.sleep(1500);
				System.out.println("\n\n남동완 배동익 정종원\n\n");
				Thread.sleep(1500);
				System.out.println("\n\n18.03.02 ~ 18.06.06\n\n");
				Thread.sleep(1500);
				System.out.println("\n\nJava Programming Project\n\n");
				Thread.sleep(1500);
				System.out.print("\n\nThe");
				Thread.sleep(1000);				
				System.out.print(" End");
				Thread.sleep(2000);
				break;
			}
	
			System.arraycopy(LevelUp(User), 0 ,User , 0, User.length);
		
			DotLine();
		}

	}

	public static void Path() throws InterruptedException, IOException
	{	
		DotLine();
		Random rd = new Random();		

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
			
		else if (a==1)
		{
			System.out.println("◀□▶     왼쪽 : 1, 오른쪽 : 3");
			while(true)
			{
				String i =input.nextLine();
				if (i.equals("1") || i.equals("3")) break;
				else System.out.println("\n갈 수 없는 방향입니다.\n");
			}			
		}	
		else if (a==2)
		{
			System.out.println("  ▲     왼쪽 : 1, 앞 : 2\n◀□");
			while(true)
			{
				String i =input.nextLine();
				if (i.equals("1") || i.equals("2")) break;
				else System.out.println("\n갈 수 없는 방향입니다.\n");
			}	
		}		
		else if (a==3)
		{
			System.out.println("  ▲     앞 : 2, 오른쪽 : 3\n  □▶");
			while(true)
			{
				String i =input.nextLine();
				if (i.equals("2") || i.equals("3")) break;
				else System.out.println("\n갈 수 없는 방향입니다.\n");
			}
		}

		System.out.println("\n\n미지의 세계에 발을 내딛는 중...");
		Thread.sleep(2000);
		DotLine();
		Travel ++;
		if (Travel %7 == 1)
		{
			Place();
			DotLine();
			Thread.sleep(2000);
		}
	}



	public static String Intro() throws InterruptedException, IOException
	{
		Scanner input = new Scanner(System.in);
	
		System.out.print("\n\n\n여기에 당신의 이름을 새겨주세요 : ");
		Thread.sleep(2000);
		
		String Name = input.nextLine();
	
		System.out.println("\n\n\n.....\n\n\n");
		Thread.sleep(800);

		System.out.println("\n\n\n..........\n\n\n");
		Thread.sleep(800);

		System.out.println("\n\n\n...............\n\n\n");
		Thread.sleep(800);

		System.out.println("\n\n\nGAME START\n\n\n");
		Thread.sleep(800);

		return Name;
	}
	


	public static int[][][] Move(int[][][] User) throws InterruptedException, IOException
	{
		
		System.out.println("\n무엇을 하시겠습니까?\n1. 이동  2. 상점  3. 아이템  4.저장/불러오기  5. 도움말");
		Scanner input = new Scanner(System.in);
		int i  = input.nextInt();
	
		if (i == 1)
		{
			Path();
			System.arraycopy(Accident(User), 0 ,User , 0, User.length);
		}		
		if (i == 2)
		{
			System.arraycopy(Shop(User), 0 , User, 0, User.length);			
		}

		if (i == 3)
		{
			System.arraycopy(UsingItem(User), 0, User, 0, User.length);	
		}

		if (i == 4)
		{	String Error = input.nextLine();
			System.out.println("\n\n하고자 하는 행동을 입력해주세요\n1. 저장\n2. 불러오기");

			while(true)
			{
				String SaveLoad = input.nextLine();
				if (SaveLoad.equals("1"))
				{
					Save(User);
					System.out.println("\n저장에 성공했습니다.");
					break;
				}
				else if (SaveLoad.equals("2"))
				{
					System.arraycopy(Load(User),0,User,0,User.length);
					System.out.println("\n불러오기에 성공했습니다.");
					break;
				}
				else System.out.println("잘못된 입력입니다. 다시 입력해주세요");
			}	
		}
		if(i == 5)
		{	DotLine();
			System.out.println("\n\n이름 : 당신의 이름입니다.");
			System.out.println("LV   : 레벨, 높아질수록 위험한 몬스터를 만나게됩니다.");
			System.out.println("체력 : 0이 되면 죽습니다.");
			System.out.println("공격 : 해당 수치만큼 몬스터에게 대미지를 줍니다.");
			System.out.println("방어 : 피해를 입을 때 해당 수치만큼 피해를 줄입니다.");
			System.out.println("행운 : 올라갈수록 도망 성공률, 이로운 이벤트 발생 확률이 증가합니다.");
			System.out.println("경험 : 몬스터를 사냥하면 획득합니다. 목표를 달성하면 레벨업합니다.");
			System.out.println("골드 : 게임에서 통용되는 재화입니다.");
			System.out.println("\n\n(실질대미지 계산식 : 체력 -= 공격 * ( 1 - ( 방어 / ( 방어 + 50 ) ) )");
			System.out.println("\n\n당신의 목표 : 최종보스 ???을 사냥하는 것");
			System.out.printf("\n최종보스까지 남은 보스의 수 : %d\n\n", 2-Finish);
			System.out.println("\n도움말을 끄려면 1을 입력하세요 :  ");
			String Error = input.nextLine();
			String exit = input.nextLine();
			while (true)
			{
				if(exit.equals("1")) break;
				else System.out.println("잘못된 입력입니다.");
			}
		}		
		return User;
	}
	
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


	public static int[][][] ApplyStatus(int[][][] User) throws InterruptedException, IOException
	{
		int[] Re = {0,0,0,0,0,0,0,0};
		
		System.arraycopy(Re, 0 , User[0][6], 0 ,Re.length);
		
		for(int i=0; i<User[0][6].length ; i++)
		{
			for (int j=0; j<User[0].length-1 ; j++)
			{
				User[0][6][i] += User[0][j][i];
			}
		}

		return User;
	}

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
			 
			if(((i == 7) && (Math.random()<=0.4)) && !(floor2))
			{
					System.out.println("\n\n???  :  이 상점에 2층이 있는 건 알고 있나?......\n\n\t학교의 마스코트인 호반우가 종종 들락거리더군.\n\t(상점에서 8을 눌러보시오)\n\n\t");
					floor2 = true;
					break;
			}
	
			if((i == 7) && (Math.random()<=0.4))
			{
				System.out.println("\n\n???  :  잠깐만. 거기 자네\n\n\t체력이 약해보이는데 이걸 구매하는 게 어떤가?\n\n\t날마다 있는 기회가 아니야.\n\n");
				Thread.sleep(800);
				System.out.println("0. 밥 먹고 살기도 힘듭니다. 1. 저 돈 많아요.(30 Gold)");
				int i1=input.nextInt();
				Thread.sleep(800);
			
			if (i1 == 0)
			{	
				System.out.println("\n\n??? : 에잇...가다가 벼락이나 맞아라!\n\n");
				lightening++;
			}	
	
			if (i1 == 1)
			{
				if(User[0][0][6]>=20)	{	
					System.out.println("\n\n???  :  긴히 쓸 데가 있을테니 잘 보관하게.\n\n");
					Thread.sleep(1000);
					User[0][0][6] -= 20;	
					System.out.println("\n\n호반우의 황금열쇠를 얻었다!\n\n");
					Thread.sleep(800);
					key++;
				}
				else	{
					System.out.println("\n\n??? : 돈도 없으면서 거짓말까지? 가다가 벼락이나 맞아라!\n\n");
					lightening++;
				}
			}

			

		}
			if (i == 0)
			{
				System.out.println("\n\n원하는 먹거리를 선택하세요.");
				System.out.println("1. 커피 (3 Gold)\n2. 단무지 없는 김밥 (10 Gold)\n3. 경대리아 감자튀김 (20 Gold)\n4. 지도못 잉어구이 (40 Gold)\n5. 교수님의 사랑 (10000000 Gold)");
				j = input.nextInt();

				if (j == 1)
				{
					System.out.print("\n\n몇 개를 구입하시겠습니까? : ");
					HowMany = input.nextInt();
					if (HowMany<1)
					{
						System.out.println("\n\n자연수를 입력해주세요.\n\n");
						break;		
					}
		 			if (User[0][0][6] - 3*HowMany >= 0)
					{
						User[0][0][6] -= 3*HowMany;
						User[1][0][0] += HowMany;
						System.out.printf("\n\n커피를 %d개 구입했습니다. (- %d Gold)\n\n", HowMany, HowMany*3);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}			
				if (j == 2)
				{
					System.out.print("\n\n몇 줄을 구입하시겠습니까? : ");
					HowMany = input.nextInt();
					if (HowMany<1)
					{
						System.out.println("\n\n자연수를 입력해주세요.\n\n");
						break;		
					}	
					if (User[0][0][6] - 10*HowMany >= 0)
					{
						User[0][0][6] -= 10*HowMany;
						User[1][0][1] += HowMany;
						System.out.printf("\n\n단무지 없는 김밥을 %d줄 구입했습니다. (- %d Gold)\n\n", HowMany, HowMany*10);
						Thread.sleep(800);
						System.out.println("\n\n화장실에서 먹기 딱 좋은 김밥이다!!!\n\n");
						Thread.sleep(800);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}			
				if (j == 3)
				{
					System.out.print("\n\n몇 봉지를 구입하시겠습니까? : ");
					HowMany = input.nextInt();
					if (HowMany<1)
					{
						System.out.println("\n\n자연수를 입력해주세요.\n\n");
						break;		
					}	
		 			if (User[0][0][6] - 20*HowMany >= 0)
					{
						User[0][0][6] -= 20*HowMany;
						User[1][0][2] += HowMany;
						System.out.printf("\n\n경대리아 감자튀김을 %d봉지 구입했습니다. (- %d Gold)\n\n", HowMany, HowMany*20);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}
				if (j == 4)
				{
					System.out.print("\n\n몇 개를 구입하시겠습니까? : ");
					HowMany = input.nextInt();
					if (HowMany<1)
					{
						System.out.println("\n\n자연수를 입력해주세요.\n\n");
						break;		
					}	
		 			if (User[0][0][6] - 40*HowMany >= 0)
					{
						User[0][0][6] -= 40*HowMany;
						User[1][0][3] += HowMany;
						System.out.printf("\n\n지도못 잉어구이를 %d개 구입했습니다. (- %d Gold)\n\n", HowMany, HowMany*40);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}
				if (j == 5)
				{
					System.out.print("\n\n??? : 안 돼. 줄 수 없어. 돌아가");
					Thread.sleep(800);
					System.out.println("\n\n학점이 부족합니다.\n\n");
				}			
			
			}

			if (i == 1)
			{
				int[] Suncap = {0,0,10,1,0,0,0,0,-1001};
				int[] Healm = {0,0,20,2,0,0,0,0,-1002};
				int[] Snapback = {0,0,40,3,0,0,0,0,-1003};

				System.out.println("\n\n원하는 장비를 선택하세요.");
				System.out.println("1. 촌스러운 썬캡 (5 Gold)\n2. 대두볼캡 (10 Gold)\n3. 스냅백 (25 Gold)");
				j = input.nextInt();

				if (j == 1)
				{
					HowMany = 1;
					
		 			if (User[0][0][6] - 5*HowMany >= 0)
					{
						User[0][0][6] -= 5*HowMany;
						System.arraycopy(Suncap, 0, User[0][1],0,Suncap.length);	
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n촌스러운 썬캡을 구입했습니다. (- %d Gold)\n\n", HowMany*5);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}			
				if (j == 2)
				{
					HowMany = 1;
					
					if (User[0][0][6] - 10*HowMany >= 0)
					{
						User[0][0][6] -= 10*HowMany;
						System.arraycopy(Healm, 0, User[0][1],0,Healm.length);	
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n대두볼캡을 구입했습니다. (- %d Gold)\n\n", HowMany*10);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}								
				if (j == 3)
				{
					HowMany = 1;
					
		 			if (User[0][0][6] - 25*HowMany >= 0)
					{
						User[0][0][6] -= 25*HowMany;
						System.arraycopy(Snapback, 0, User[0][1],0,Snapback.length);	
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n스냅백을 구입했습니다. (- %d Gold)\n\n", HowMany*25);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}		
			}

			if (i == 2)
			{
				int[] Tshirt = {0,0,10,1,0,0,0,0,-2001};
				int[] Sweater = {0,0,20,2,0,0,0,0,-2002};
				int[] Jacket = {0,0,40,3,0,0,0,0,-2003};

				System.out.println("\n\n원하는 장비를 선택하세요.");
				System.out.println("1. 목 늘어난 티셔츠 (5 Gold)\n2. 쪼그라든 스웨터 (10 Gold)\n3. 빛나는 과잠 (20 Gold)");
				j = input.nextInt();

				if (j == 1)
				{
					HowMany = 1;
					
		 			if (User[0][0][6] - 5*HowMany >= 0)
					{
						User[0][0][6] -= 5*HowMany;
						System.arraycopy(Tshirt, 0, User[0][2],0,Tshirt.length);	
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n목 늘어난 티셔츠를 구입했습니다. (- %d Gold)\n\n", HowMany*5);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}			
				if (j == 2)
				{
					HowMany = 1;
					
					if (User[0][0][6] - 10*HowMany >= 0)
					{
						User[0][0][6] -= 10*HowMany;
						System.arraycopy(Sweater, 0, User[0][2],0,Sweater.length);	
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n쪼그라든 스웨터를 구입했습니다. (- %d Gold)\n\n", HowMany*10);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}
				if (j == 3)
				{
					HowMany = 1;
					
					if (User[0][0][6] - 20*HowMany >= 0)
					{
						User[0][0][6] -= 20*HowMany;
						System.arraycopy(Jacket, 0, User[0][2],0,Jacket.length);
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n빛나는 과잠을 구입했습니다. (- %d Gold)\n\n", HowMany*20);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}			
			}

			if (i == 3)
			{
				int[] Training = {0,0,10,1,0,0,0,0,-3001};//체육복 반바지
				int[] Jean = {0,0,30,2,0,0,0,0,-3002};//찢어진 청바지
				int[] NewJean = {0,0,30,2,0,0,0,0,-3003};//뉴 클래식 데님 데미지드 진
				int[] PsyPants = {0,0,60,2,0,0,0,0,-3003};//싸이의 나팔바지
				
				System.out.println("\n\n원하는 장비를 선택하세요.");			
				System.out.println("1. 체육복 반바지 (5 Gold)\n2. 찢어진 청바지 (10 Gold)\n3. 뉴 클래식 데님 데미지드 진 ( 20 Gold)\n4. 싸이의 나팔바지 ( 40 Gold)");
				j = input.nextInt();

				if (j == 1)
				{
					HowMany = 1;
					
		 			if (User[0][0][6] - 5*HowMany >= 0)
					{
						User[0][0][6] -= 5*HowMany;
						System.arraycopy(Training, 0, User[0][3],0,Training.length);
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n체육복 반바지를 구입했습니다. (- %d Gold)\n\n", HowMany*5);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}			
				if (j == 2)
				{
					HowMany = 1;
					
					if (User[0][0][6] - 10*HowMany >= 0)
					{
						User[0][0][6] -= 10*HowMany;
						System.arraycopy(Jean, 0, User[0][3],0,Jean.length);
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n찢어진 청바지를 구입했습니다. (- %d Gold)\n\n", HowMany*10);
					}	
						else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}
                                if (j == 3)
				{
					HowMany = 1;
					
					if (User[0][0][6] - 20*HowMany >= 0)
					{
						User[0][0][6] -= 20*HowMany;
						System.arraycopy(NewJean, 0, User[0][3],0,NewJean.length);
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n뉴 클래식 데님 데미지드 진을 구입했습니다. (- %d Gold)", HowMany*20);
						Thread.sleep(1500);
						System.out.println("\n\n상점 주인 : 그거 그냥 찢어진 청바지야. 역시 영어로 해 놓으니 잘 팔리네. \n\n이 참에 상점의 모든 물품을 영어로 바꿔버려?\n\n");
						Thread.sleep(2000);
						System.out.println("\n\n속았다......\n\n");
						Thread.sleep(1500);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}
				if (j == 4)
				{
					HowMany = 1;
					
					if (User[0][0][6] - 40*HowMany >= 0)
					{
						User[0][0][6] -= 40*HowMany;
						System.arraycopy(PsyPants, 0, User[0][3],0,PsyPants.length);
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n싸이의 나팔바지를 구입했습니다. (- %d Gold)\n\n", HowMany*40);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}
			}

			if (i == 4)
			{
				
				int[] Slippers = {0,0,10,1,0,0,0,0,-4001};//삼선 슬리퍼
				int[] Sneakers = {0,0,20,2,0,0,0,0,-4002};//흰 운동화
				int[] RollerSkates = {0,0,40,3,0,0,0,0,-4003};//롤러스케이트
				int[] Shoes = {0,0,60,4,0,0,0,0,-4004};//50cm 깔창 구두

				System.out.println("\n\n원하는 장비를 선택하세요.");			
				System.out.println("1. 삼선 슬리퍼 (10 Gold)\n2. 흰 운동화 (20 Gold)\n3. 롤러 스케이트 (30 Gold)\n4. 50cm 깔창 구두 (40 Gold)");
				j = input.nextInt();

				if (j == 1)
				{
					HowMany = 1;
					
		 			if (User[0][0][6] - 10*HowMany >= 0)
					{
						User[0][0][6] -= 10*HowMany;
						System.arraycopy(Slippers, 0, User[0][4],0,Slippers.length);
					
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n삼선 슬리퍼를 구입했습니다. (- %d Gold)\n\n", HowMany*10);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}			
				if (j == 2)
				{
					HowMany = 1;
					
					if (User[0][0][6] - 20*HowMany >= 0)
					{
						User[0][0][6] -= 20*HowMany;
						System.arraycopy(Sneakers, 0, User[0][4],0,Sneakers.length);
					
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n흰 운동화를 구입했습니다. (- %d Gold)\n\n", HowMany*20);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
				if (j == 3)
				{
					HowMany = 1;
					
		 			if (User[0][0][6] - 30*HowMany >= 0)
					{
						User[0][0][6] -= 30*HowMany;
						System.arraycopy(RollerSkates, 0, User[0][4],0,RollerSkates.length);
					
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n롤러 스케이트를 구입했습니다. (- %d Gold)\n\n", HowMany*30);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}	
				}	
				}
				if (j == 4)
				{
					HowMany = 1;
					
					if (User[0][0][6] - 40*HowMany >= 0)
					{
						User[0][0][6] -= 40*HowMany;
						System.arraycopy(Shoes, 0, User[0][4],0,Shoes.length);
					
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n50cm 깔창 구두를 구입했습니다. (- %d Gold)\n\n", HowMany*40);
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
					
				}
			}

			if (i == 5)
			{
				int[] Umbrella = {0,20,0,0,0,0,0,0,-5001};
				int[] Book = {0,50,0,0,0,0,0,0,-5002};
				int[] LighteningRod = {0,70,0,0,0,0,0,0,-5003};//1호관 옥상의 피뢰침
				int[] Scholarship = {0,100,0,0,0,0,0,0,-5004};//과탑의 장학증서

				System.out.println("\n\n원하는 장비를 선택하세요.");
				System.out.println("1. 장우산 (40 Gold)\n2. 두꺼운 전공책 (80 Gold)\n3. 1호관 옥상의 피뢰침 (130 Gold)\n4. 과탑의 장학증서 (250 Gold)");
				j = input.nextInt();

				if (j == 1)
				{
					HowMany = 1;
					
					if (User[0][0][6] - 40*HowMany >= 0)
					{
						User[0][0][6] -= 40*HowMany;
						
						System.arraycopy(Umbrella, 0, User[0][5],0,Umbrella.length);
					
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n장우산을 구입했습니다. (- %d Gold)\n\n", HowMany*40);	
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}				
				}
				if (j == 2)
				{
					HowMany = 1;
					
					if (User[0][0][6] - 80*HowMany >= 0)
					{
						User[0][0][6] -= 80*HowMany;
						System.arraycopy(Book, 0, User[0][5],0,Book.length);
					
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n두꺼운 전공책을 구입했습니다. (- %d Gold)\n\n", HowMany*80);				
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
				}
				if (j == 3)
				{
					HowMany = 1;
					
					if (User[0][0][6] - 130*HowMany >= 0)
					{
						User[0][0][6] -= 130*HowMany;
						System.arraycopy(LighteningRod, 0, User[0][5],0,LighteningRod.length);
					
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n1호관 옥상의 피뢰침을 구입했습니다. (- %d Gold)\n\n", HowMany*130);					
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
				}
				if (j == 4)
				{
					HowMany = 1;
					
					if (User[0][0][6] - 250*HowMany >= 0)
					{
						User[0][0][6] -= 250*HowMany;
						System.arraycopy(Scholarship, 0, User[0][5],0,Scholarship.length);
					
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n과탑의 장학증서를 구입했습니다. (- %d Gold)\n\n", HowMany*250);					
					}	
					else
					{
						System.out.println("\n\n골드가 부족합니다.\n\n");
					}
				}		
			}

			if (i == 7)
			{
				System.out.println("\n\n\n상점에서 나갑니다.");				
				break;
			}
			
			if (i == 8)
			{
				if (floor2)
				{
					Thread.sleep(800);
					System.out.println("\n\n\n숨겨진 상점의 2층으로 올라왔습니다.\n\n");
					Thread.sleep(800);
					System.out.println("\n\n호반우의 금고가 놓여져 있습니다. 황금열쇠를 사용하시겠습니까?\n\n");
					Thread.sleep(800);
					System.out.println("\n\n1. 사용한다. 2. 사용하지 않는다.\n\n");
					int a=input.nextInt();

					if( a == 1 && key>=1)
					{
						System.out.println("\n\n호반우의 축복으로 최대체력이 10 증가하였습니다\n\n");
						Thread.sleep(800);
						User[0][0][5] += 10;
					}

					else if ( a == 1 && key ==0 ) System.out.println("\n\n황금열쇠가 없어.\n\n");
					else System.out.println("\n\n아직은 사용할 때가 아니야.\n\n");
							
				}
			
			}

			if (i == 6)
			{
				System.out.println("\n\n뭐야, 아직 안 갔어?\n\n");
				Thread.sleep(800);
				System.out.println("\n\n1. 오늘 날씨가 참 좋네요.  2. 갈게요. 안녕히 계세요.\n\n");

				int option=input.nextInt();

				if (option == 1)
				{
					System.out.println("\n\n미세먼지 자욱한 거 안 보이니?\n\n");
					Thread.sleep(800);
					System.out.println("\n\n(...역시 안 통한다.)\n\n");
					Thread.sleep(800);
				}

				else if (option == 2)
				{
					System.out.println("\n\n\n잠깐만 기다려봐. 자네 요즘 영 힘이 없어보여.\n\n커피 한 잔 마시고 가게.\n\n");
					Thread.sleep(800);
					System.out.println("\n\n1. 이미 세 잔 마셨어요.  2. 감사합니다.\n\n");
					Thread.sleep(800);
						int option1=input.nextInt();
						if( option1 == 1)
						{
							System.out.println("\n\n그렇다면야...\n\n");
						}
						else if( option1 == 2)
						{
								User[1][0][1] += 1;
								System.out.println("\n\n돈은 내고 가야지. 1 Gold야.\n\n");
								Thread.sleep(800);
								if(User[0][0][6]<=0)	{System.out.println("\n\n돈이 없구만. 다음에 다시 오게. 흐흐.\n\n");}
								else	{
									User[0][0][6] -= 1;
								}
								System.out.println("\n\n......\n\n");
						}
				}

			}
					
		}
		
		return User;
	}

	
	public static int[][][] UsingItem(int[][][] User) throws InterruptedException, IOException
	{
		DotLine();
		Scanner input = new Scanner(System.in);
		
		int NoItem = 0;
		System.out.println("-- 사용 가능한 아이템 목록 --");
		if (User[1][0][0] == 0 && User[1][0][1] == 0 && User[1][0][2] == 0 && User[1][0][3] == 0)
		{

			NoItem = 1;
		}
		
		else
		{	NoItem = 0;
			if (User[1][0][0] > 0) System.out.printf("\n1. 커피 : %d개", User[1][0][0]);
			if (User[1][0][1] > 0) System.out.printf("\n2. 단무지 없는 김밥 : %d줄", User[1][0][1]);
			if (User[1][0][2] > 0) System.out.printf("\n3. 경대리아 감자튀김 : %d봉지", User[1][0][2]);
			if (User[1][0][3] > 0) System.out.printf("\n4. 지도못 잉어구이 : %d개", User[1][0][3]);
		}

		if (NoItem > 0)
		{
			System.out.println("\n\n사용할 수 있는 아이템이 없습니다!");
			NoItem = 0;
		}
		else
		{
			System.out.println("\n\n\n무엇을 사용하시겠습니까? : ");
			int Item = input.nextInt();
			if (Item == 1 && User[1][0][0] > 0)
			{
				User[1][0][0] -=1;
				if (User[0][0][0] + 5 > User[0][0][5])
				{
					System.out.printf("체력을 회복하였습니다. (%d->%d)\n\n", User[0][0][0], User[0][0][5]);
					User[0][0][0] = User[0][0][5];
				}
				else
				{
					System.out.printf("체력을 회복하였습니다. (%d->%d)\n\n", User[0][0][0], User[0][0][0]+5);
					User[0][0][0] += 5;
				}
				
				System.arraycopy(ApplyStatus(User), 0, User,0,User.length);				

			}
			else if (Item == 2&& User[1][0][1] > 0)
			{
				User[1][0][1] -=1;
				if (User[0][0][0] + 15 > User[0][0][5])
				{
					System.out.printf("체력을 회복하였습니다. (%d->%d)\n\n", User[0][0][0], User[0][0][5]);
					User[0][0][0] = User[0][0][5];
				}
				else
				{
					System.out.printf("체력을 회복하였습니다. (%d->%d)\n\n", User[0][0][0], User[0][0][0]+10);
					User[0][0][0] += 15;
				}
				
				System.arraycopy(ApplyStatus(User), 0, User,0,User.length);				

			}
			else if (Item == 3&& User[1][0][2] > 0)
			{
				User[1][0][2] -=1;
				if (User[0][0][0] + 30 > User[0][0][5])
				{
					System.out.printf("체력을 회복하였습니다. (%d->%d)\n\n", User[0][0][0], User[0][0][5]);
					User[0][0][0] = User[0][0][5];
				}
				else
				{
					System.out.printf("체력을 회복하였습니다. (%d->%d)\n\n", User[0][0][0], User[0][0][0]+20);
					User[0][0][0] += 30;
				}
				
				System.arraycopy(ApplyStatus(User), 0, User,0,User.length);				

			}
			else if (Item == 4&& User[1][0][3] > 0)
			{
				User[1][0][3] -=1;
				if (User[0][0][0] + 50 > User[0][0][5])
				{
					System.out.printf("체력을 회복하였습니다. (%d->%d)\n\n", User[0][0][0], User[0][0][5]);
					User[0][0][0] = User[0][0][5];
				}
				else
				{
					System.out.printf("체력을 회복하였습니다. (%d->%d)\n\n", User[0][0][0], User[0][0][0]+40);
					User[0][0][0] += 50;
				}
				
				System.arraycopy(ApplyStatus(User), 0, User,0,User.length);				

			}
			else
			{
				System.out.println("\n\n없는 아이템입니다!");
			}
		}
		return User;
	}

	
	public static String Index(int Num) throws InterruptedException, IOException
	{
		       if (Num == -1000) return "허름한 모자";
		else if (Num == -1001) return "촌스러운 썬캡";
		else if (Num == -1002) return "대두볼캡";
		else if (Num == -1003) return "스냅백";

		else if (Num == -2000) return "허름한 상의";
		else if (Num == -2001) return "목늘어난 티셔츠";
		else if (Num == -2002) return "쪼그라든 스웨터";
		else if (Num == -2003) return "빛나는 과잠";

		else if (Num == -3000) return "허름한 하의";
		else if (Num == -3001) return "체육복 반바지";
		else if (Num == -3002) return "찢어진 청바지";
		else if (Num == -3003) return "데미지드진";
		else if (Num == -3004) return "싸이의 나팔바지";

		else if (Num == -4000) return "허름한 신발";
		else if (Num == -4001) return "삼선 슬리퍼";
		else if (Num == -4002) return "흰 운동화";
		else if (Num == -4003) return "롤러 스케이트";
		else if (Num == -4004) return "50cm 깔창 구두";

		else if (Num == -5000) return "낡은 지팡이";
		else if (Num == -5001) return "장우산";
		else if (Num == -5002) return "두꺼운 전공책";
		else if (Num == -5003) return "피뢰침";
		else if (Num == -5004) return "과탑의 장학증서";
		else return "없음";
	}


	public static void Save(int[][][] User) throws InterruptedException, IOException
	{
		File save = new File("save.txt");
		
		PrintWriter output = new PrintWriter(save);

		for(int i = 0;i<User.length;i++)
		{
			for(int j = 0;j<User[i].length;j++)
			{
				for(int k = 0;k<User[i][j].length;k++)
				{
					output.print(User[i][j][k]+" ");
				}
			}
		}
		output.print(Name);
		output.print(" ");
		output.print(Finish);
		output.print(" ");
		output.print(Travel);
		output.close();
	}

	public static int[][][] Load(int[][][] User) throws InterruptedException, IOException
	{
		File save = new File("save.txt");

		Scanner input = new Scanner(save);
		
		for(int i = 0;i<User.length;i++)
		{
			for(int j = 0;j<User[i].length;j++)
			{
				for(int k = 0;k<User[i][j].length;k++)
				{
					User[i][j][k] = Integer.parseInt(input.next());
				}
			}
		}

		Name = input.next();
		Finish = Integer.parseInt(input.next());
		Travel = Integer.parseInt(input.next());
		input.close();

		return User;
	}

	public static int pibonachi(int n)
	{
		int pib = 1;
		int org = 1;
		int temp = 0;

		for(int i = 0; i < n; i++)
		{	
			temp = org;
			org = pib;
			pib = pib + temp;
		}
		
		
		return pib;
	}

	public static void DotLine()
	{
		System.out.print("\n\n\n----------------------------------------------------------\n\n\n");
	}

	public static int[][][] Reseraction()
	{
		int[][][] User =  {{{20, 2, 2, 3, 0,20,0,1},{0,0,3,0,0,0,0,0,-1000},{0,0,2,0,0,0,0,0,-2000},{0,0,2,0,0,0,0,0,-3000},{0,0,2,0,0,0,0,0,-4000},{0,9,0,0,0,0,0,0,-5000},{0,0,0,0,0,0,0,0}},{{3,0,0,0,0}}};
		
		return User;
	}
	
	public static int[][][] LevelUp(int[][][] User) throws InterruptedException
	{
		Random rd = new Random();
		while(User[0][6][0] > 0)
		{
			if (User[0][0][4] >= pibonachi(User[0][0][7]))
			{
				System.out.print("\n\n\nLevel ");
				Thread.sleep(800);
				System.out.print("Up!");
				Thread.sleep(800);
				System.out.printf("\n\n(LV%d -> LV%d)\n",User[0][0][7], User[0][0][7]+1);
				User[0][0][4] -= pibonachi(User[0][0][7]);
				int Atk = (int)((0.75+rd.nextDouble())*User[0][0][7]);
				User[0][0][1] += Atk;
				int Arm = (int)((0.75+rd.nextDouble())*User[0][0][7]);
				User[0][0][2] += Arm;
				int Lck = (int)((0.75+rd.nextDouble())*User[0][0][7]);
				User[0][0][3] += Lck;
				int MaxH = (int)((1+rd.nextDouble())*User[0][0][7]);
				User[0][0][5] += MaxH;
				User[0][0][0] = User[0][0][5];
				System.out.println("\n능력치가 상승합니다.");
				System.out.printf("\n최대체력 :  + %d", User[0][0][7] + MaxH);
				System.out.printf("\n공격     :  + %d", Atk);
				System.out.printf("\n방어     :  + %d", Arm);
				System.out.printf("\n행운     :  + %d", Lck);
				User[0][0][7]++;	
				Thread.sleep(2000);
			}
			else break;
		}
		return User;
	}

	public static void Place()
	{	Random rd = new Random();
		int RandomPlace = rd.nextInt(12);
		System.out.println();
		if (RandomPlace == 0) System.out.println("*** 경북대 정문 ***");
		else if (RandomPlace == 1) System.out.println("*** IT 1호관 ***");
		else if (RandomPlace == 2) System.out.println("*** IT 2호관 ***");
		else if (RandomPlace == 3) System.out.println("*** IT 3호관 ***");
		else if (RandomPlace == 4) System.out.println("*** 공학관 식당 ***");
		else if (RandomPlace == 5) System.out.println("*** 도서관 ***");
		else if (RandomPlace == 6) System.out.println("*** 쪽문 사거리 ***");
		else if (RandomPlace == 7) System.out.println("*** 외진 구석 ***");
		else if (RandomPlace == 8) System.out.println("*** 생활관 구역 ***");
		else if (RandomPlace == 8) System.out.println("*** 공원 ***");
		else if (RandomPlace == 9) System.out.println("*** 지도못 ***");
		else if (RandomPlace == 10) System.out.println("*** 미지의 공간 ***");
		else if (RandomPlace == 11) System.out.println("*** 시내 ***");
		else System.out.println("*** 가로수길 ***");
	}































































	
}



















