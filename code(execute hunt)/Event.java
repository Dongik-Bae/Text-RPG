import java.util.*;
import java.io.IOException;
import java.util.Random;

public class Event
{
	static Random rd = new Random();
	static int route = 0;
	static boolean revenge = false;

	public static void DotLine()
	{
		System.out.print("\n\n\n----------------------------------------------------------\n\n\n");
	}

	public static int[][][] MetEvent(int[][][] User) throws InterruptedException, IOException
	{
		int a = rd.nextInt(100);
		
		if (a <= 5)
		{
			System.arraycopy(Gamble(User), 0 ,User , 0, User.length);				
		}
		else if (a <= 10)
		{
			System.arraycopy(Shaman(User), 0 ,User, 0, User.length);			
		}

		else if (a <= 17)
		{
			System.arraycopy(Hole(User), 0 ,User, 0, User.length);			
		}

		else if (a <= 36)
		{
			System.arraycopy(Gold(User), 0 ,User, 0, User.length);			
		}

		else if (a <= 45)
		{
			System.arraycopy(Message(User), 0 ,User, 0, User.length);			
		}
		
		else if (a<= 55)
		{
			System.arraycopy(Strange(User), 0 ,User, 0, User.length);			
		}

		else if (a<= 65)
		{
			System.arraycopy(Garbage(User), 0 ,User, 0, User.length);			
		}
		
		else if (a <= 90)
		{
			System.arraycopy(Box(User), 0 ,User, 0, User.length);			
		}
		
		else
		{
			System.arraycopy(Will(User), 0 ,User, 0, User.length);
		}

		return User;
	}



	public static int[][][] Gamble(int [][][] User) throws InterruptedException, IOException
	{
		Scanner input = new Scanner(System.in);
		System.out.printf("비밀 도박판이 열려있습니다... 참가하시겠습니까? (참가비 50골드) \n\n");
		System.out.printf("참가한다 : 1, 하지 않는다 : 2\n");
		int bat = 0;

		try
		{	
			int join = input.nextInt();
		
			if(join == 1 && User[0][0][6] > 50)
			{	User[0][0][6] -= 50;
				System.out.println("\n\n(참가비 -50골드)");
				while(true)
				{
					System.out.printf("\n\n어떤 게임을 하고 싶으신가요?\n\n");
					System.out.printf("홀짝 : 1\n가위바위보 : 2\n주사위 눈 맞추기 : 3\n");
					int select = input.nextInt();
			
					System.out.printf("\n\n배팅하실 금액을 설정해주세요. (현재 금액 : %d)\n", User[0][0][6]);

					while(true)
					{
						bat = input.nextInt();
						if(User[0][0][6] < bat)
						{
							System.out.println("\n\n가진 돈 보다 많이는 걸 수 없습니다.");
						}
						else 
						{
							System.out.printf("\n\n그럼 선택하신 게임을 시작하겠습니다.\n");
							break;
						}
					}
			
					if(select == 1)
					{
						System.out.printf("\n\n홀과 짝중에서 하나를 선택해주세요.");
						System.out.println("\n\n홀 : 1, 짝 : 2");
						int a3 = input.nextInt();
						int a4 = rd.nextInt(1)+1;
						if(a3 == a4)
						{
							System.out.printf("\n\n승리! (골드 +%d)\n",bat * 2);
							User[0][0][6] += bat*2;
						}
					
						else
						{
							System.out.printf("\n\n패배... (골드 -%d)\n",bat);
							User[0][0][6] -= bat;
						}
				
					}

					else if (select == 2)
					{
						System.out.printf("\n\n가위 바위 보 중에 하나를 선택하여 내주세요.\n");
						System.out.printf("\n\n가위 : 1, 바위 : 2, 보 : 3\n");
						int a6 = input.nextInt();
						int a7 = rd.nextInt(2)+1;
						if(a6==a7)
						{
							System.out.printf("\n\n무승부...\n");
						}
				
						else if(a6==1&&a7==2||a6==2&&a7==3||a6==3&&a7==1)
						{
							System.out.printf("\n\n패배... (골드 -%d)\n",bat);
							User[0][0][6] -= bat;
					
						}
						else if(a6==1&&a7==3||a6==2&&a7==1||a6==3||a7==2)
						{
							System.out.printf("\n\n승리! (골드 +%d)\n",bat * 3);
							User[0][0][6] += bat*3;
						}
					}

					else if (select==3)
					{
						System.out.printf("\n\n1~6까지의 숫자를 하나 입력하여주세요.\n");
						int a8= input.nextInt();
						int a9 = rd.nextInt(6)+1;
				
						if(a8==a9)
						{
							System.out.printf("\n\n승리! (골드 +%d)\n",bat * 6);
							User[0][0][6] += bat*6;
						}
						else
						{	
							System.out.printf("\n\n패배... (골드 -%d)\n",bat);
							User[0][0][6] -= bat;
						}
					}

					System.out.println("\n\n도박을 계속하시겠습니까?");
					System.out.println("예 : 1, 아니오 : 2");
					int end = input.nextInt();

					if (User[0][0][6] <= 0)
					{
						System.out.println("\n\n돈을 모두 잃었습니다. 도박판에서 강퇴당합니다.");
						break;
					
					}

					else if (end == 2) 
					{
						System.out.println("\n\n도박장에서 나갑니다.\n\n");
						break;
					}
					else System.out.println("\n\n도박을 계속합니다.");

				}
			}

			else if (join == 2) System.out.println("\n\n발을 들이지 않고 떠납니다.");
			else if (User[0][0][6] <= 50) System.out.println("\n\n돈이 부족하여 참가가 불가합니다.");
			else System.out.println("\n\n잘못된 입력입니다. 도박장에서 강퇴당합니다.");
		}
		catch(InputMismatchException ex)
		{
			System.out.println("\n\n잘못된 입력입니다. 도박판에서 강퇴당합니다.");
			return User;
		}
		

		return User;
	}

	public static int[][][] Box(int[][][] User) throws InterruptedException, IOException
	{	Scanner input = new Scanner(System.in);
		try
		{
			System.out.println("\n\n상자를 발견했습니다. 여시겠습니까?\n\n1. 예, 2. 아니오");
			int i = input.nextInt();
			if (i == 1)
			{
		
				int aa=rd.nextInt(100);//상자의 랜덤성 부여 랜덤 숫자 수정해야함
				if(aa < 25)
				{		
					int bb = rd.nextInt(User[0][6][5] - User[0][6][3]);
					System.out.printf("\n\n상자에서 독기가 퍼져나왔습니다.(체력 -%d)\n",bb);
					User[0][0][0] -= bb;		

				}	
			
				else if(aa < 40)
				{
					int RP = rd.nextInt(10)+1;
					System.out.printf("상자 안에 커피가 들어있습니다! (커피 +%d개)", RP);
					User[1][0][0] += RP;

				}

				else if(aa < 65)
				{
					int dd = rd.nextInt(User[0][6][3]) + 1;
					User[0][0][6] += dd;
					System.out.printf("\n\n상자에서 골드가 나왔습니다.(골드 +%d)\n",dd);

				}
			
				else if(aa < 80)
				{
					System.out.printf("\n\n몬스터가 나타났습니다!!!\n\n");
					Thread.sleep(1500);
					Fight fight = new Fight();
					System.arraycopy(fight.MetMonster(User), 0 ,User, 0, User.length);	
				}

				else System.out.println("\n\n상자는 텅 비어있습니다...");

				return User;
			}
			
			else
			{
				System.out.println("\n\n상자를 지나칩니다.");
				Thread.sleep(1500);
				return User;
			}
			
		
		}
		catch(InputMismatchException ex)
		{
			System.out.println("잘못된 입력입니다. 상자를 지나칩니다.");
			return User;
		}

		
	}

	public static int[][][] Shaman(int[][][] User) throws InterruptedException, IOException 
	{	Scanner input = new Scanner(System.in);
		try
		{
			System.out.println("\n점쟁이 아주머니를 만났습니다. 말을 거시겠습니까??\n\n");
			System.out.println("\n말을 건다 : 1, 말을 걸지 않는다 : 2\n");
			int a1 = input.nextInt();
			if(a1==1)
			{
				System.out.println("호호호 여행자여 점을 보기를 원하는가?\n");
				System.out.println("점을 보기를 원한다 :1, 원치 않는다 : 2\n");
				int a2 = input. nextInt();
			
				if(a2==1)	
				{
					System.out.println("\n호호호 여행자여 내가 너의 점을 봐주지\n\n점괘가 나빠도 나를 원망하지 말게나\n");
					Thread.sleep(1500);
					int a3 = (int)(Math.random()*4);
				
				
					if( a3==0) 
					{
						System.out.println("\n점괘가 아주 고약하군.... 물을 조심하라구... 큰일이 날수도있어\n");
						User[0][0][3]-=2;
						if (User[0][0][3] < 0) User[0][0][3] = 0;
						Thread.sleep(1500);
					}
				
					if(a3==1)
					{
						System.out.println("\n이런 살면서 점괘는 처음보는군... 당신.. 목숨이 위험해!\n");
						User[0][0][3]-=5;
						if (User[0][0][3] < 0) User[0][0][3] = 0;
						Thread.sleep(1500);
					}
				
					if(a3==2)
					{
						System.out.println("\n음...오늘은 별 일 없겟구만.. \n좋은일도 나쁜일도 일어나지 않아...\n");
						//행운 그대로	
						Thread.sleep(1500);
					}
					if(a3==3)
					{
						System.out.println("\n오! 좋은 점괘구만.. 틀림없이 오늘은 좋은일이 생길것이야\n");
						User[0][0][3]+=2;
						Thread.sleep(1500);	
					}

					if(a3==4)
					{
						System.out.println("\n이런 좋은 점괘는 살면서 처음보는군!!\n 당신 복권이라도 사보는게 어떻겠나?\n");
						User[0][0][3]+=5;	
						Thread.sleep(1500);
					}
				
				}
			
				if(a2==2)
				{
					System.out.println("\n점을 볼것도 아니면서 왜 말을 건거야?\n\n가던길이나 가시게 나는 바쁜 몸 이라고!!\n");
					System.out.println("\n점쟁이가 자리를 떠납니다.\n");
					Thread.sleep(1500);
				}
			
			}
			if(a1==2)
			{	
				System.out.println("\n\n당신은 점쟁이를 지나쳤다.\n");
				Thread.sleep(1500);
			}
		}

		catch(InputMismatchException ex)
		{
			System.out.println("잘못된 입력입니다. 점쟁이를 지나칩니다.");
			Thread.sleep(1500);
			return User;
		}
		
		return User;
	}

	


	public static int[][][] Hole (int[][][] User) throws InterruptedException, IOException 
	{	Scanner input = new Scanner(System.in);
		try
		{
			System.out.printf("재수 없게 커다란 구멍에 빠져 버렸습니다. 구멍에서 빠져나와야 합니다. \n\n");
			System.out.printf("구멍을 올라가기 위해 8번을 눌러주세요 : ");
			int a1 = input.nextInt();
		
			int Depth = rd.nextInt(100);
			double a4 = 0.4;
	
			while(true)
			{
				if (a1 == 8)
				{
					System.out.printf("\n\n\n구멍을 올라가는 중입니다.\n");
					Thread.sleep(1500);

					int fail = (int)(Math.random()*User[0][6][3]);

					if(fail <= User[0][0][7])
					{
						System.out.printf("\n\n발을 헛디뎌 미끄러졋습니다. 조심해서 다시 올라갑시다.\n");
						a4 += 0.1;
					}
					else break;
				}

				else
				{
					System.out.printf("8번을 눌러주셔야 합니다. 8번을 눌러주세요 \n");
					a1 = input.nextInt();
				}
			}

	
			System.out.printf("\n\n");
			int last = (int)(a4 * User[0][6][5]);
			System.out.printf("구멍을 다 올라 왔습니다. (체력 -%d)\n",last);
			User[0][0][0] -= last;
			User[0][6][0] -= last;
		
		}
		catch(InputMismatchException ex)
		{
			System.out.println("잘못된 입력입니다. 구덩이에서 굶어 죽습니다.");
			User[0][0][0] = 0;
			User[0][6][0] = 0;
			return User;
		}
	
		return User;		

	
	}
	
	public static int[][][] Gold(int[][][] User) throws InterruptedException, IOException
	{	Scanner input = new Scanner(System.in);
		try
		{
			System.out.printf("길가의 골드 떨어져 있는것을 발견했습니다. 주우시겠습니까?\n");
			System.out.println("줍는다 : 1, 그냥 둔다 : 2");

			int a1 = input.nextInt();
			if(a1==1)
			{
				int a2 =rd.nextInt(User[0][6][3]) + 1;
				System.out.printf("\n\n골드 +%d",a2);
				User[0][0][6] += a2;
				
				if (rd.nextInt(100) > User[0][6][3])
				{	Thread.sleep(1500);
					System.out.println("\n\n??? : 거기 당신, 무슨 짓을 하는 거지?");
					Thread.sleep(2000);
					System.out.println("\n\n경찰이 나타났습니다!");
					Thread.sleep(1500);
					System.out.println("\n\n경찰 : 당신을 절도 현행범으로 긴급 체포합니다.");
					Thread.sleep(1500);
					System.out.printf("\n\n당신은 가진 돈을 모두 벌금으로 뺐겼다.\n(골드 -%d)", User[0][0][6]);
					User[0][6][6] = 0;
					User[0][0][6] = 0;
				}

			}

			if(a1==2)
			{
				System.out.println("\n\n가던 길을 갑니다...");
			}
		}
		catch(InputMismatchException ex)
		{
			System.out.println("잘못된 입력입니다. 가던 길을 갑니다.");
			return User;
		}
		return User;
	}


	public static int[][][] Will(int[][][] User) throws InterruptedException, IOException
	{	Scanner input = new Scanner(System.in);
		System.out.print("\n\t★");
		Thread.sleep(500);
		System.out.print("\b\b☆");
		Thread.sleep(500);
		System.out.print("\b\b★");
		Thread.sleep(500);
		System.out.print("\b\b☆");
		Thread.sleep(500);
		System.out.print("\b\b★");
		Thread.sleep(500);
		System.out.print("\b\b☆");
		Thread.sleep(500);
		System.out.print("\b\b★");
		Thread.sleep(500);
		System.out.print("\b\b☆");
		Thread.sleep(500);		

		System.out.println("\n\n눈 앞에 무언가가 빛나고 있습니다.");
		System.out.println("\n\n건드리시겠습니까?  예 : 1, 아니오 : 2");
		String s = input.nextLine();

		if(s.equals("1"))
		{
			System.out.println("\n\n당신의 의지가 가득 찼다.");
			User[0][0][0] = User[0][0][5];
		}
		else System.out.println("\n\n당신은 가던 길을 갔다.");

		return User;
	}


	public static int[][][] Strange (int [][][] User) throws InterruptedException, IOException
	{	Scanner input = new Scanner(System.in);
		if(route <= 1)
		{
			System.out.println("\n\n??? : 저기요, 저 좀 도와주실래요?");
			System.out.println("\n\n낯선 남자가 당신에게 도움을 구합니다. 어떻게 하시겠습니까?");
			System.out.println("도와준다 : 1, 꺼져 : 2");
			String select = input.nextLine();

			if (select.equals("1") && route == 0)
			{
				System.out.println("\n\n??? : 차비가 없어서 그러는 데 50골드만 주실 수 있으신가요?\n준다 : 1, 꺼져 : 2");
				String r1select = input.nextLine();

				if(r1select.equals("1") && User[0][0][6] >= 50)
				{
					User[0][0][6] -= 50;
					User[0][0][4] += 3;
					System.out.println("\n\n??? : 감사합니다. 이 은혜는 잊지 않겠습니다.");
					Thread.sleep(1500);
					System.out.println("\n\n남자가 당신을 떠나갑니다.");
					System.out.println("(골드 -50, 경험 +3)\n");
					Thread.sleep(1500);
				}	

				else if(r1select.equals("1") && User[0][0][6] < 50)
				{
					System.out.println("\n\n\n??? : 뭐야? 거렁뱅이잖아?\n\n남자는 당신을 떠나갑니다.");
					Thread.sleep(1500);
				}

				else
				{
					System.out.println("\n\n??? : 그렇군, 주지 않겠다면 어쩔 수 없지...");
					Thread.sleep(1500);
					System.out.println("\n\n남자가 당신의 지갑에 손을 댑니다!");
					Thread.sleep(1500);
					System.out.println("\n\n저지하시겠습니까?\n예 : 1, 아니오 : 2");
					String r11select = input.nextLine();
	
					if(r11select.equals("1"))
					{
						System.out.println("\n\n당신은 남자를 저지했다!");
						revenge = true;
						Thread.sleep(500);
						int MoneyStolen = rd.nextInt(User[0][0][6]);
						User[0][0][6] -= MoneyStolen;
						System.out.printf("\n\n하지만 돈을 전부 지키는 데에는 실패했다! (골드 -%d)\n\n", MoneyStolen);
						Thread.sleep(1500);
					}	
	
					else
					{
						System.out.printf("\n\n남자는 당신의 돈을 전부 가져갔다!(골드 -%d)", User[0][0][6]);
						Thread.sleep(1500);
						User[0][0][6] = 0;
					}			
								
				}
			
				route ++;
			}
	
			else if(select.equals("1") && route == 1 && !revenge)
			{
				System.out.println("\n\n??? : 아! 당신은 저번에 날 도와줬던 그 분이군요!");
				Thread.sleep(1500);
				System.out.println("\n\n낯선 남자가 당신에게 답례를 하고는 떠나갑니다.");
				System.out.println("(골드 + 100, 경험 + 50)");
				Thread.sleep(1500);
				User[0][0][6] += 100; User[0][0][4] += 5;
				route ++;
			}

			else if(select.equals("1") && route == 1 && revenge)
			{
				System.out.println("\n\n배에서 서늘한 기운이 느껴진다...");
				Thread.sleep(1500);
				System.out.println("\n\n남자가 당신을 칼로 찔렀다!");
				User[0][0][0] = 0;
				User[0][6][0] = 0;
				Thread.sleep(1500);
			}


			else if(select.equals("2"))
			{
				System.out.println("\n\n당신은 그를 무시하고 지나쳤다.\n");
				Thread.sleep(1500);
			}
			else
			{	Thread.sleep(1500);
				System.out.println("\n\n남자는 당신의 얼굴을 보고는 달아났다.\n");
				Thread.sleep(1500);	
			} 
		
		}
		else
		{
			Fight fight = new Fight();
			System.arraycopy(fight.MetMonster(User), 0 ,User, 0, User.length);
		}
		return User;
		
	}

	public static int[][][] Message(int[][][] User) throws InterruptedException
	{	Scanner input = new Scanner(System.in);
		int a = rd.nextInt(100);
		int Awake = 0;
		System.out.println("\n\n쪽지가 놓여 있습니다. 읽어보시겠습니까?\n예 : 1, 아니오 : 2\n");
		String select = input.nextLine();

		if(select.equals("1"))
		{
			if(a<10)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n...오래된 피를 두려워하라...");
				Thread.sleep(2500);
				System.out.println("\n\n알 수 없는 문구로부터 깨달음을 얻었다.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(경험 + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;				
			}

			else if(a<15)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n...나는 데스윙, 만물의 종결자, 내가 바로 대격변이다!");
				Thread.sleep(2500);
				System.out.println("\n\n왠지 모르게 하늘에서 커다란 용이 날뛰는 기분이 되었다.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(경험 + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}

			else if(a<24)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n...**야, 사실 나... 널 좋아해... 예전부터 말이야, ...");
				Thread.sleep(2500);
				System.out.println("\n\n기분 나쁜 고백편지였다. 당신은 그 자리에서 쪽지를 찢었다.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(경험 - %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]-= Awake;
								
			}

			else if(a<35)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n난...ㄱ ㅏ 끔... 눈물을 흘린 ㄷ ㅏ... ㄱ ㅏ 끔은 눈물을 참을 수 없는 ...");
				Thread.sleep(2500);
				System.out.println("\n\n관심종자의 헛소리다. 당신은 쪽지를 갈갈이 찢었다.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(경험 + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}

			else if(a<39)
			{	
				Thread.sleep(1500);
				System.out.println("\n\nTo be or not To be, that is the question");
				Thread.sleep(2500);
				System.out.println("\n\n위대한 자의 명언이다. 당신에게 깨우침을 준다.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(경험 + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}

			else if(a<47)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n!@#%$#^@#$@#$!#^#%&%#$#$%@)*&^");
				Thread.sleep(2500);
				System.out.println("\n\n형태를 알아볼 수 없는 글자들이다. 무엇을 암시하는 걸까?");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(경험 + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}

			else if(a<54)
			{	
				Thread.sleep(1500);
				System.out.println("\n\nOOH, Majestic! Hunter is a hunter even in a dream!");
				Thread.sleep(2500);
				System.out.println("\n\n꿈 속을 헤집는 사냥꾼에 대한 감평인 것 같다.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(경험 + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}

			else if(a<59)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n...신랑과 신부는 커피시간에 초대되었다. 그날 커피를 제공한 소년소녀들 가운데...");
				Thread.sleep(2500);
				System.out.println("\n\n책의 한 부분이 찢겨져 있다. 무슨 책인 지는 알 수 없다.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(경험 + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}

			
			else if(a<68)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n비주기님 만세");
				Thread.sleep(2500);
				System.out.println("\n\n닫힌 문의 암호인 것 같다.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(경험 + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}


			else
			{
				System.out.println("\n\n텅 빈 쪽지이다.");
				Thread.sleep(1500);
			}
		}
		else
		{
			System.out.println("\n\n당신은 쪽지를 지나쳤다.");
			Thread.sleep(1500);	
		}
		return User;
	}

	public static int[][][] Garbage(int[][][] User) throws InterruptedException
	{	Scanner input = new Scanner(System.in);
		System.out.println("당신은 쓰레기더미를 마주했다.");
		Thread.sleep(1500);
		System.out.println("\n\n어떻게 하시겠습니까?\n1. 조사한다, 2. 지나친다.");
		String select = input.nextLine();
		while(select.equals("1"))
		{	int trash = rd.nextInt(User[0][6][3]);
			int met = rd.nextInt(100);
			if(trash < 4)
			{
				System.out.println("\n\n아무리 뒤져도 쓰레기 뿐입니다.");
			}
			
			else if(trash < 6)
			{
				System.out.println("\n\n아무 짝에도 쓸모 없는 쓰레기를 찾았습니다.");
			}
			else if(trash < 9 && met<50)
			{	int Stt = rd.nextInt((int)(50/User[0][6][2])+1)+1;
				System.out.printf("\n\n깨진 유리조각에 손을 베였습니다.\n(체력 -%d)\n\n",Stt);
				User[0][0][0] -= Stt;
				User[0][6][0] -= Stt;
				Thread.sleep(1500);
			}
			else if(trash < 10&& met<50)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)+1;
				System.out.printf("\n\n광인의 지식이 든 해골을 발견했습니다.\n(경험 +%d)\n\n",Stt);
				User[0][0][4] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 12&& met<50)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)*2+1;
				System.out.printf("\n\n위대한 자의 지혜가 든 성물을 발견했습니다.\n(경험 +%d)\n\n",Stt);
				User[0][0][4] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 16&& met<50)
			{	int Stt = rd.nextInt((int)(50/User[0][6][2])+1)*2+1;
				System.out.printf("\n\n역한 냄새에 당신은 그만 구토하였습니다.\n(체력 -%d)\n\n",Stt);
				User[0][0][0] -= Stt;
				User[0][6][0] -= Stt;
				Thread.sleep(1500);
			}
			else if(trash < 17&& met<40)
			{	int Stt = rd.nextInt((User[0][6][3]/User[0][0][7])+1)+1;
				System.out.printf("\n\n오래된 책에서 신비한 주문을 깨우쳤습니다.\n(행운 +%d)\n\n",Stt);
				User[0][0][3] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 20&& met<40)
			{	int Stt = rd.nextInt((User[0][6][3]/User[0][0][7])+1)*2+1;
				System.out.printf("\n\n예쁜 부적을 발견했s습니다. 좋은 기운이 당신을 휘감습니다.\n(행운 +%d)\n\n",Stt);
				User[0][0][3] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 22&& met<40)
			{	int Stt = rd.nextInt((int)(User[0][6][3]/2)+1)+1;
				System.out.printf("\n\n이상한 부적을 발견했습니다. 기분 나쁜 기운이 당신을 뒤덮습니다.\n(행운 -%d)\n\n",Stt);
				User[0][0][3] -= Stt;
				if(User[0][0][3] < 0) User[0][0][3] =0;
				Thread.sleep(1500);
			}
			else if(trash < 24&& met<40)
			{	int Stt = rd.nextInt((int)(User[0][6][3]/2)+1)*2+1;
				System.out.printf("\n\n흉측한 인형을 찾았습니다. 기분이 매우 더러워졌습니다.\n(행운 -%d)\n\n",Stt);
				User[0][0][3] -= Stt;
				if(User[0][0][3] < 0) User[0][0][3] =0;
				Thread.sleep(1500);
			}
			else if(trash < 25&& met<30)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)+1;//
				System.out.printf("\n\n거미에게 물렸습니다.\n(공격 +%d)\n\n",Stt);
				User[0][0][1] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 27&& met<30)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)*2+1;
				System.out.printf("\n\n알 수 없는 혈청이 든 주사기에 찔렸습니다.\n(공격 +%d)\n\n",Stt);
				User[0][0][1] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 29&& met<30)
			{	int Stt = rd.nextInt((int)(User[0][6][2]/1.3)+1)+1;
				System.out.printf("\n\n염산이 손에 묻었습니다.\n(방어 -%d)\n\n",Stt);
				User[0][0][2] -= Stt;
				if(User[0][0][2] < 0) User[0][0][2] =0;
				Thread.sleep(1500);
			}
			else if(trash < 31&& met<30)
			{	int Stt = rd.nextInt((int)(User[0][6][2]/1.3)+1)*2+1;
				System.out.printf("\n\n누군가가 당신의 머리에 껌을 붙였습니다.\n(방어 -%d)\n\n",Stt);
				User[0][0][2] -= Stt;
				if(User[0][0][2] < 0) User[0][0][2] =0;
				Thread.sleep(1500);
			}
			else if(trash < 33&& met<20)
			{	int Stt = rd.nextInt((User[0][6][0]/User[0][6][3])+1)*3+1;
				System.out.printf("\n\n누군가가 당신의 뒤통수를 후려갈겼습니다.\n(체력 -%d)\n\n",Stt);
				User[0][0][0] -= Stt;
				User[0][6][0] -= Stt;
				Thread.sleep(1500);
			}
			else if(trash < 34&& met<20)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)+1;
				System.out.printf("\n\n인삼 농축액을 발견했습니다. 찜찜했지만 당신은 그냥 먹기로 합니다.\n(최대체력 +%d)\n\n",Stt);
				User[0][0][5] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 37&& met<20)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)*2+1;
				System.out.printf("\n\n하얀 포션을 찾았습니다. 지나친 포션 복용은 오히려 건강에 좋습니다.\n(최대체력 +%d)\n\n",Stt);
				User[0][0][5] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 39&& met<20)
			{	int Stt = rd.nextInt(User[0][6][5]+1)+1;
				System.out.printf("\n\n부정한 성배의 오탁이 당신에게 저주를 내렸습니다.\n(최대체력 -%d)\n\n",Stt);
				User[0][0][5] -= Stt;
				if(User[0][0][5] < 1) User[0][0][5] =1;
				Thread.sleep(1500);
			}
			else if(trash < 42&& met<10)
			{	int Stt = rd.nextInt((User[0][6][6]/User[0][6][3])+1)*2+1;
				System.out.printf("\n\n당신은 갑자기 쓰레기더미를 뒤지는 자신에게 회의감을 느꼈습니다.\n(최대체력 -%d)\n\n",Stt);
				User[0][0][5] -= Stt;
				if(User[0][0][5] < 1) User[0][0][5] =1;
				Thread.sleep(1500);
			}
			else if(trash < 45&& met<10)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)+1;
				System.out.printf("\n\n당신이 쓰레기를 뒤지던 와중, 뜬금없이 하늘에서 가호가 내려왔습니다.\n(방어 +%d)\n\n",Stt);
				User[0][0][2] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 50&& met<10)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)*2+1;
				System.out.printf("\n\n멈추지 않는 신의 은혜가 당신에게 내려옵니다.\n(방어 +%d)\n\n",Stt);
				User[0][0][2] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 55&& met<10)
			{	int Stt = rd.nextInt((int)(User[0][0][6]/1.1)+1)+1;
				System.out.printf("\n\n너무 조사에 열중한 나머지, 당신은 골드를 흘렸습니다.\n(골드 -%d)\n\n",Stt);
				User[0][0][6] -= Stt;
				if(User[0][0][6] < 0) User[0][0][6] =0;
				Thread.sleep(1500);
			}
			else if(trash < 58 && met<5)
			{	
				System.out.printf("\n\n누군가가 당신의 지갑을 훔쳐 달아났습니다.\n(골드 -%d)\n\n",User[0][0][6]);
				Thread.sleep(1500);
				User[0][0][6] = 0;
				User[0][6][6] = 0;
			}
			else if(trash < 62 && met<5)
			{	
				System.out.printf("\n\n설치된 함정이 작동했습니다. 당신은 독화살을 맞았습니다.\n\n");
				User[0][0][0] = 0;
				User[0][6][0] = 0;
			}
			else if(trash < 65 && met<5)
			{
				int Stt = rd.nextInt(User[0][0][7] + User[0][6][3])+1;
				System.out.printf("\n\n버려진 골드를 주웠습니다.\n(골드 +%d)\n\n",Stt);
				User[0][0][6] += Stt;
				Thread.sleep(1500);
			}

			else
			{
				System.out.println("\n\n쓰레기를 찾았습니다.");
			}

			if(User[0][0][0] <= 0) break;
			System.out.println("\n\n조사를 계속하시겠습니까?\n1. 예, 2. 아니오");
			select = input.nextLine();
				
		}
		if(User[0][0][0] > 0) System.out.println("\n\n쓰레기를 지나칩니다.");	
		Thread.sleep(1500);
		return User;
	}








}