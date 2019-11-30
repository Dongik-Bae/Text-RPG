import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class Boss extends Fight
{	

	static int BossEncounter = 0;
	static int intro = 0;
	static int P2counter= 0;

	Boss(){}

	Boss(int a, int b, int c, int d, int e, int f, int g, int h, String Name)
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

	public static int[][][] MetBoss(int[][][] User) throws InterruptedException, IOException
	{	BossEncounter = Hunt.Finish;

		if (BossEncounter == 0)
		{
			Boss Gs = new Boss(200, 30, 10, 1000000000,40,0,20,5, "C를 잘 주는 물리교수");
			System.arraycopy(Gs.Battle(User),0,User,0,User.length);
		}
		
		else if(BossEncounter == 1)
		{
			Boss TOEIC = new Boss(400, 100, 60, 1000000000,80,0,500,10, "살아있는 토익시험");
			System.arraycopy(TOEIC.Battle(User),0,User,0,User.length);
		}

		else if(BossEncounter == 2)
		{
			Boss MM = new Boss(800, 300, 100, 1000000000,120,0,500,10, "취업 면접관");
			System.arraycopy(MM.Battle(User),0,User,0,User.length);
		}

		else;
		

		return User;
	}
	
	public static int[][][] Battle(int [][][] User) throws InterruptedException, IOException
	{	
		Hunt hunt = new Hunt();
		Scanner input = new Scanner(System.in);
		
		int StartHealth = Status[0];


		if (intro == 0)
		{
			Meant(MonsterName);

			System.out.printf("Boss %d : %s이(가) 당신 가까이 와 있습니다.", BossEncounter + 1,MonsterName);

			Thread.sleep(3000);
			intro = 1;
		}

		else
	{

		System.out.printf("\n당신은 %s와(과) 마주했다!", MonsterName);
		while(true)
		{
			System.out.printf("\n(%s LV : %d, 체력 : %d, 공격력 %d)\n",MonsterName,Status[7],Status[0],Status[1]);
			System.out.println("\n무엇을 하시겠습니까?\n공격 : 1, 도망 : 2, 아이템 : 3");	
			int  i = input.nextInt();

			if (i == 1)
			{
				Status[0] -= DamageCalculation(User[0][6][1], Status[2]);
					
				System.out.printf("\n당신은 %s을(를) 공격합니다.\n",MonsterName);
					
				if (Status[0] > 0)
				{
					System.out.printf("(%s 체력 : %d)\n", MonsterName,Status[0]);
					Thread.sleep(1500);
				}
				else
				{
					System.out.printf("(%s 체력 : 0)\n", MonsterName);
					Thread.sleep(1500);
				}

				if (Status[0] <= 0)
				{	
					Meant(MonsterName);

					System.out.printf("\n당신은 %s에게서 승리했다!\n", MonsterName);
					System.out.printf("(경험 +%d, 골드 +%d)\n\n", Status[4], Status[6]);
					User[0][0][4] += Status[4];
					User[0][0][6] += Status[6];
					
					BossEncounter ++;
					intro = 0;
					P2counter = 0;
				
					break;
				}

				if(P2counter == 0 && Status[0]< StartHealth/2 )
				{
					P2counter = 1;
					System.arraycopy(Pase2(Status, MonsterName), 0, Status,0,Status.length);
					
					
				}

				System.out.printf("\n%s이(가) 당신을 공격합니다.\n\n", MonsterName);
				Thread.sleep(500);
				
				String Sentence = RandomSentence(MonsterName);
				System.out.printf("피하고 싶다면 5초 안에 커맨드를 입력하세요. (커맨드 : %s)\n\n", Sentence);
				long start = System.currentTimeMillis();

				String err = input.nextLine();
				String commend = input.nextLine();
				
				long end = System.currentTimeMillis();
				
				if(commend.equals(Sentence) && (end - start)<5000)
				{
					System.out.println("\n\n회피 성공!\n\n");
					Thread.sleep(1500);
				}

				else
				{
					System.out.println("\n\n회피 실패...\n\n");	
					Thread.sleep(1500);
					
					User[0][0][0] -= DamageCalculation(Status[1], User[0][6][2]);
					User[0][6][0] -= DamageCalculation(Status[1], User[0][6][2]);
					

					if (User[0][6][0] > 0)
					{
						System.out.printf("(당신의 체력 : %d)\n", User[0][6][0]);
						Thread.sleep(1500);
					}
					else
					{
						System.out.printf("(당신의 체력 : 0)\n");
						Thread.sleep(1500);
					}

					if (User[0][6][0] <=0)
					{
						System.out.printf("\n%s이(가) 당신을 처치했습니다.\n\n",MonsterName);
						intro = 0;
						P2counter = 0;
						break;
					}
				}
			}

			if (i==2)
			{
				if ((int)(Math.random()*User[0][6][3]) > (int)(Math.random()*Status[3]))
				{	Thread.sleep(3000);
					System.out.println("\n도망 성공!.\n"); break;	
				}
				else
				{	Thread.sleep(1500);
					System.out.println("\n도망 실패!");
					System.out.printf("%s이(가) 당신을 공격합니다.\n",MonsterName);

					User[0][0][0] -= DamageCalculation(Status[1], User[0][6][2]);
					User[0][6][0] -= DamageCalculation(Status[1], User[0][6][2]);
					
						
					System.out.printf("(당신의 체력 : %d)\n", User[0][6][0]);
					Thread.sleep(1500);

					if (User[0][6][0] <=0)
					{
						System.out.printf("\n%s이(가) 당신을 처치했습니다.\n\n",MonsterName);
						intro = 0;
						P2counter = 0;
						break;
					}		
				}
			}		
				
			if(i == 3)
			{
					
				System.arraycopy(hunt.UsingItem(User),0,User,0,User.length);	

				System.out.printf("\n%s이 당신을 공격합니다.\n", MonsterName);
				Thread.sleep(1500);

				User[0][0][0] -= DamageCalculation(Status[1], User[0][6][2]);
				User[0][6][0] -= DamageCalculation(Status[1], User[0][6][2]);
				

				if (User[0][6][0] > 0)
				{
					System.out.printf("(당신의 체력 : %d)\n", User[0][6][0]);
				}
				else
				{
					System.out.printf("(당신의 체력 : 0)\n");
				}

				if (User[0][6][0] <=0)
				{
					System.out.printf("\n%s이(가) 당신을 처치했습니다.\n\n",MonsterName);
					intro = 0;
					P2counter = 0;
					break;
				}
			}


		}
	}

		return User;
	}

	


	public static String RandomSentence(String Name) throws InterruptedException, IOException
	{
		
		Random rd = new Random();

		int p1 = 23; int p2 = 37; int p3 = 50; int p4 = 70;

		int a = rd.nextInt(100);
		String Sentence ="";

		if (a < p1 && Name.equals("살아있는 토익시험")) Sentence = "Life is Dramatic";
		else if (a < p1 && Name.equals("C를 잘 주는 물리교수")) Sentence = "V=IR";
		else if (a < p1 && Name.equals("취업 면접관")) Sentence = "저는 평범한 가정에서 3남 중 장남으로 태어나...";

		else if (a < p2 && Name.equals("살아있는 토익시험")) Sentence = "Life is Traumatic";
		else if (a < p2 && Name.equals("C를 잘 주는 물리교수")) Sentence = "I(t)=CdV(t)/dt";
		else if (a < p2 && Name.equals("취업 면접관")) Sentence = "제 좌우명은 '열심히 살자'입니다.";

		else if (a < p3 && Name.equals("살아있는 토익시험")) Sentence = "Freezing Cold Shatters My Sorrow";
		else if (a < p3 && Name.equals("C를 잘 주는 물리교수")) Sentence = "H=Ia^2/2(a^2+z^2)^(3/2)";
		else if (a < p3 && Name.equals("취업 면접관")) Sentence = "이 기업에 뼈를 묻도록 하죠!";

		else if (a < p4 && Name.equals("살아있는 토익시험")) Sentence = "Scorching Sand Put It Together Again";
		else if (a < p4 && Name.equals("C를 잘 주는 물리교수")) Sentence = "F=ma, W=Fd, P=dW/dt";
		else if (a < p4 && Name.equals("취업 면접관")) Sentence = "간장공장공장장은 간공장장, 김장공장공장장은 김공장장";

		
		else Sentence = "Miss";
		
		return Sentence;

	}



	public static void Meant(String Name) throws InterruptedException, IOException
	{
		if (Name.equals("C를 잘 주는 물리교수") && intro == 0)
		{	
			DDD();

			System.out.printf("\n??? : 사방에");
			Thread.sleep(750);
			System.out.printf(" C학점자가 있다...");
			Thread.sleep(750);
			System.out.println("\n\n");

			Thread.sleep(1500);

			System.out.printf("      너도");
			Thread.sleep(1000);
			System.out.printf(" 곧 그렇게 될 거야...");
			Thread.sleep(1000);
			System.out.println("\n\n");

			DDD();
		}	

		else if(Name.equals("C를 잘 주는 물리교수") && intro == 1)
		{
			System.out.printf("\n\n\nC를 잘 주는 물리교수 :  젠장...");

			Thread.sleep(1500);

			System.out.printf("네 학점은 A다...\n\n");
			DDD();
		}

		else if (Name.equals("살아있는 토익시험") && intro == 0)
		{	
			DDD();

			System.out.printf("\n??? : 취업을 ");
			Thread.sleep(750);
			System.out.printf("하고 싶다고...?");
			Thread.sleep(750);
			System.out.println("\n\n");

			Thread.sleep(1500);

			System.out.printf("     그 스펙으로");
			Thread.sleep(1000);
			System.out.printf(" 잘도 하겠군");
			Thread.sleep(1000);
			System.out.printf(" ㅋ");
			Thread.sleep(1000);
			System.out.printf("ㅋㅋ");
			Thread.sleep(800);
			System.out.printf("ㅋㅋㅋ");
			Thread.sleep(600);
			System.out.printf("ㅋㅋㅋㅋ");
			Thread.sleep(400);
			System.out.printf("ㅋㅋㅋㅋㅋ");
			Thread.sleep(200);
			System.out.printf("ㅋㅋㅋㅋㅋㅋ");
			Thread.sleep(100);
			System.out.printf("ㅋㅋㅋㅋㅋㅋㅋ");
			Thread.sleep(50);
			System.out.println("\n\n");

			DDD();
		}	

		else if(Name.equals("살아있는 토익시험") && intro == 1)
		{
			System.out.printf("\n\n\n살아있는 토익시험 :  LC, RC");

			Thread.sleep(1500);

			System.out.printf(" 모두 만점이구나!\n\n");
			DDD();
		}

		else if (Name.equals("취업 면접관") && intro == 0)
		{	
			DDD();

			System.out.printf("\n??? : 다음 지원자 ");
			Thread.sleep(750);
			System.out.printf("들어오세요...");
			Thread.sleep(750);
			System.out.println("\n\n");

			Thread.sleep(1500);

			System.out.printf("      자기소개를");
			Thread.sleep(1000);
			System.out.printf(" 해주실래요?");
			Thread.sleep(1000);
			System.out.println("\n\n");

			DDD();
		}	

		else if(Name.equals("취업 면접관") && intro == 1)
		{
			System.out.printf("\n\n\n취업 면접관 : 내일 부터 ");
			Thread.sleep(1500);
			System.out.printf(" 출근하세요...\n\n");
			Thread.sleep(1500);
			DDD();
		}



		else;	

	}

	public static int[] Pase2(int[] Status, String Name) throws InterruptedException, IOException
	{
		if(Name.equals("C를 잘 주는 물리교수"))
		{
			System.out.println("\n\nC를 잘 주는 물리교수의 상태가 변합니다.\n\n");
			Thread.sleep(1500);
			System.out.println("C를 잘 주는 물리교수가 분노하였습니다.\n\n");
			Thread.sleep(1500);
			System.out.println("C를 잘 주는 물리교수의 공격력과 방어력이 상승합니다.\n\n");
			Thread.sleep(1500);

			Status[1] += 40;
			Status[2] += 40;

			return Status;
			
		}

		else if(Name.equals("살아있는 토익시험"))
		{
			System.out.println("\n\n살아있는 토익시험 :  오오!! 난이도를 좀 올려 볼까?.\n\n");
			Thread.sleep(1500);
			System.out.println("살아있는 토익시험의 난이도가 상승하였습니다.\n\n");
			Thread.sleep(1500);
			System.out.println("살아있는 토익시험의 공격력과 방어력이 상승합니다.\n\n");
			Thread.sleep(1500);

			Status[1] += 80;
			Status[2] += 80;

			return Status;
			
		}

		else if(Name.equals("취업 면접관"))
		{
			System.out.println("\n\n취업 면접관 :  자기소개서에 적힌 내용에 대해 질문해보겠습니다.\n\n");
			Thread.sleep(1500);
			System.out.println("취업 면접관이 깐깐하게 굴기 시작하였습니다.\n\n");
			Thread.sleep(1500);
			System.out.println("취업 면접관이 미쳐 날뜁니다!\n\n");
			Thread.sleep(1500);

			Status[1] += 120;
			Status[2] += 120;

			return Status;
			
		}


		else return Status;
	}

	public static void DDD() throws InterruptedException
	{
		System.out.printf("...");
		Thread.sleep(500);
		System.out.printf("\b ");
		Thread.sleep(500);
		System.out.printf("\b.");
		Thread.sleep(500);
		System.out.printf("\b ");
		Thread.sleep(500);
		System.out.printf("\b.");
		Thread.sleep(500);
		System.out.printf("\b ");
		Thread.sleep(500);
		System.out.printf("\b.");
		Thread.sleep(1500);
		System.out.printf("\n\n");
	}














}