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
		Status[0] = a; // 端径
		Status[1] = b; // 因維
		Status[2] = c; // 号嬢
		Status[3] = d; // 楳錘
		Status[4] = e; // 井蝿
		Status[5] = f; // 置企端径
		Status[6] = g; // 茨球
		Status[7] = h; // 傾婚
		MonsterName = Name;
		
	}

	public static int[][][] MetBoss(int[][][] User) throws InterruptedException, IOException
	{	BossEncounter = Hunt.Finish;

		if (BossEncounter == 0)
		{
			Boss Gs = new Boss(200, 30, 10, 1000000000,40,0,20,5, "C研 設 爽澗 弘軒嘘呪");
			System.arraycopy(Gs.Battle(User),0,User,0,User.length);
		}
		
		else if(BossEncounter == 1)
		{
			Boss TOEIC = new Boss(400, 100, 60, 1000000000,80,0,500,10, "詞焼赤澗 塘斥獣蝿");
			System.arraycopy(TOEIC.Battle(User),0,User,0,User.length);
		}

		else if(BossEncounter == 2)
		{
			Boss MM = new Boss(800, 300, 100, 1000000000,120,0,500,10, "昼穣 檎羨淫");
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

			System.out.printf("Boss %d : %s戚(亜) 雁重 亜猿戚 人 赤柔艦陥.", BossEncounter + 1,MonsterName);

			Thread.sleep(3000);
			intro = 1;
		}

		else
	{

		System.out.printf("\n雁重精 %s人(引) 原爽梅陥!", MonsterName);
		while(true)
		{
			System.out.printf("\n(%s LV : %d, 端径 : %d, 因維径 %d)\n",MonsterName,Status[7],Status[0],Status[1]);
			System.out.println("\n巷譲聖 馬獣畏柔艦猿?\n因維 : 1, 亀諺 : 2, 焼戚奴 : 3");	
			int  i = input.nextInt();

			if (i == 1)
			{
				Status[0] -= DamageCalculation(User[0][6][1], Status[2]);
					
				System.out.printf("\n雁重精 %s聖(研) 因維杯艦陥.\n",MonsterName);
					
				if (Status[0] > 0)
				{
					System.out.printf("(%s 端径 : %d)\n", MonsterName,Status[0]);
					Thread.sleep(1500);
				}
				else
				{
					System.out.printf("(%s 端径 : 0)\n", MonsterName);
					Thread.sleep(1500);
				}

				if (Status[0] <= 0)
				{	
					Meant(MonsterName);

					System.out.printf("\n雁重精 %s拭惟辞 渋軒梅陥!\n", MonsterName);
					System.out.printf("(井蝿 +%d, 茨球 +%d)\n\n", Status[4], Status[6]);
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

				System.out.printf("\n%s戚(亜) 雁重聖 因維杯艦陥.\n\n", MonsterName);
				Thread.sleep(500);
				
				String Sentence = RandomSentence(MonsterName);
				System.out.printf("杷馬壱 粛陥檎 5段 照拭 朕固球研 脊径馬室推. (朕固球 : %s)\n\n", Sentence);
				long start = System.currentTimeMillis();

				String err = input.nextLine();
				String commend = input.nextLine();
				
				long end = System.currentTimeMillis();
				
				if(commend.equals(Sentence) && (end - start)<5000)
				{
					System.out.println("\n\n噺杷 失因!\n\n");
					Thread.sleep(1500);
				}

				else
				{
					System.out.println("\n\n噺杷 叔鳶...\n\n");	
					Thread.sleep(1500);
					
					User[0][0][0] -= DamageCalculation(Status[1], User[0][6][2]);
					User[0][6][0] -= DamageCalculation(Status[1], User[0][6][2]);
					

					if (User[0][6][0] > 0)
					{
						System.out.printf("(雁重税 端径 : %d)\n", User[0][6][0]);
						Thread.sleep(1500);
					}
					else
					{
						System.out.printf("(雁重税 端径 : 0)\n");
						Thread.sleep(1500);
					}

					if (User[0][6][0] <=0)
					{
						System.out.printf("\n%s戚(亜) 雁重聖 坦帖梅柔艦陥.\n\n",MonsterName);
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
					System.out.println("\n亀諺 失因!.\n"); break;	
				}
				else
				{	Thread.sleep(1500);
					System.out.println("\n亀諺 叔鳶!");
					System.out.printf("%s戚(亜) 雁重聖 因維杯艦陥.\n",MonsterName);

					User[0][0][0] -= DamageCalculation(Status[1], User[0][6][2]);
					User[0][6][0] -= DamageCalculation(Status[1], User[0][6][2]);
					
						
					System.out.printf("(雁重税 端径 : %d)\n", User[0][6][0]);
					Thread.sleep(1500);

					if (User[0][6][0] <=0)
					{
						System.out.printf("\n%s戚(亜) 雁重聖 坦帖梅柔艦陥.\n\n",MonsterName);
						intro = 0;
						P2counter = 0;
						break;
					}		
				}
			}		
				
			if(i == 3)
			{
					
				System.arraycopy(hunt.UsingItem(User),0,User,0,User.length);	

				System.out.printf("\n%s戚 雁重聖 因維杯艦陥.\n", MonsterName);
				Thread.sleep(1500);

				User[0][0][0] -= DamageCalculation(Status[1], User[0][6][2]);
				User[0][6][0] -= DamageCalculation(Status[1], User[0][6][2]);
				

				if (User[0][6][0] > 0)
				{
					System.out.printf("(雁重税 端径 : %d)\n", User[0][6][0]);
				}
				else
				{
					System.out.printf("(雁重税 端径 : 0)\n");
				}

				if (User[0][6][0] <=0)
				{
					System.out.printf("\n%s戚(亜) 雁重聖 坦帖梅柔艦陥.\n\n",MonsterName);
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

		if (a < p1 && Name.equals("詞焼赤澗 塘斥獣蝿")) Sentence = "Life is Dramatic";
		else if (a < p1 && Name.equals("C研 設 爽澗 弘軒嘘呪")) Sentence = "V=IR";
		else if (a < p1 && Name.equals("昼穣 檎羨淫")) Sentence = "煽澗 汝骨廃 亜舛拭辞 3害 掻 舌害生稽 殿嬢蟹...";

		else if (a < p2 && Name.equals("詞焼赤澗 塘斥獣蝿")) Sentence = "Life is Traumatic";
		else if (a < p2 && Name.equals("C研 設 爽澗 弘軒嘘呪")) Sentence = "I(t)=CdV(t)/dt";
		else if (a < p2 && Name.equals("昼穣 檎羨淫")) Sentence = "薦 疎酔誤精 '伸宿備 詞切'脊艦陥.";

		else if (a < p3 && Name.equals("詞焼赤澗 塘斥獣蝿")) Sentence = "Freezing Cold Shatters My Sorrow";
		else if (a < p3 && Name.equals("C研 設 爽澗 弘軒嘘呪")) Sentence = "H=Ia^2/2(a^2+z^2)^(3/2)";
		else if (a < p3 && Name.equals("昼穣 檎羨淫")) Sentence = "戚 奄穣拭 酸研 康亀系 馬倉!";

		else if (a < p4 && Name.equals("詞焼赤澗 塘斥獣蝿")) Sentence = "Scorching Sand Put It Together Again";
		else if (a < p4 && Name.equals("C研 設 爽澗 弘軒嘘呪")) Sentence = "F=ma, W=Fd, P=dW/dt";
		else if (a < p4 && Name.equals("昼穣 檎羨淫")) Sentence = "娃舌因舌因舌舌精 娃因舌舌, 沿舌因舌因舌舌精 沿因舌舌";

		
		else Sentence = "Miss";
		
		return Sentence;

	}



	public static void Meant(String Name) throws InterruptedException, IOException
	{
		if (Name.equals("C研 設 爽澗 弘軒嘘呪") && intro == 0)
		{	
			DDD();

			System.out.printf("\n??? : 紫号拭");
			Thread.sleep(750);
			System.out.printf(" C俳繊切亜 赤陥...");
			Thread.sleep(750);
			System.out.println("\n\n");

			Thread.sleep(1500);

			System.out.printf("      格亀");
			Thread.sleep(1000);
			System.out.printf(" 稲 益係惟 吃 暗醤...");
			Thread.sleep(1000);
			System.out.println("\n\n");

			DDD();
		}	

		else if(Name.equals("C研 設 爽澗 弘軒嘘呪") && intro == 1)
		{
			System.out.printf("\n\n\nC研 設 爽澗 弘軒嘘呪 :  賎舌...");

			Thread.sleep(1500);

			System.out.printf("革 俳繊精 A陥...\n\n");
			DDD();
		}

		else if (Name.equals("詞焼赤澗 塘斥獣蝿") && intro == 0)
		{	
			DDD();

			System.out.printf("\n??? : 昼穣聖 ");
			Thread.sleep(750);
			System.out.printf("馬壱 粛陥壱...?");
			Thread.sleep(750);
			System.out.println("\n\n");

			Thread.sleep(1500);

			System.out.printf("     益 什薙生稽");
			Thread.sleep(1000);
			System.out.printf(" 設亀 馬畏浦");
			Thread.sleep(1000);
			System.out.printf(" せ");
			Thread.sleep(1000);
			System.out.printf("せせ");
			Thread.sleep(800);
			System.out.printf("せせせ");
			Thread.sleep(600);
			System.out.printf("せせせせ");
			Thread.sleep(400);
			System.out.printf("せせせせせ");
			Thread.sleep(200);
			System.out.printf("せせせせせせ");
			Thread.sleep(100);
			System.out.printf("せせせせせせせ");
			Thread.sleep(50);
			System.out.println("\n\n");

			DDD();
		}	

		else if(Name.equals("詞焼赤澗 塘斥獣蝿") && intro == 1)
		{
			System.out.printf("\n\n\n詞焼赤澗 塘斥獣蝿 :  LC, RC");

			Thread.sleep(1500);

			System.out.printf(" 乞砧 幻繊戚姥蟹!\n\n");
			DDD();
		}

		else if (Name.equals("昼穣 檎羨淫") && intro == 0)
		{	
			DDD();

			System.out.printf("\n??? : 陥製 走据切 ");
			Thread.sleep(750);
			System.out.printf("級嬢神室推...");
			Thread.sleep(750);
			System.out.println("\n\n");

			Thread.sleep(1500);

			System.out.printf("      切奄社鯵研");
			Thread.sleep(1000);
			System.out.printf(" 背爽叔掘推?");
			Thread.sleep(1000);
			System.out.println("\n\n");

			DDD();
		}	

		else if(Name.equals("昼穣 檎羨淫") && intro == 1)
		{
			System.out.printf("\n\n\n昼穣 檎羨淫 : 鎧析 採斗 ");
			Thread.sleep(1500);
			System.out.printf(" 窒悦馬室推...\n\n");
			Thread.sleep(1500);
			DDD();
		}



		else;	

	}

	public static int[] Pase2(int[] Status, String Name) throws InterruptedException, IOException
	{
		if(Name.equals("C研 設 爽澗 弘軒嘘呪"))
		{
			System.out.println("\n\nC研 設 爽澗 弘軒嘘呪税 雌殿亜 痕杯艦陥.\n\n");
			Thread.sleep(1500);
			System.out.println("C研 設 爽澗 弘軒嘘呪亜 歳葛馬心柔艦陥.\n\n");
			Thread.sleep(1500);
			System.out.println("C研 設 爽澗 弘軒嘘呪税 因維径引 号嬢径戚 雌渋杯艦陥.\n\n");
			Thread.sleep(1500);

			Status[1] += 40;
			Status[2] += 40;

			return Status;
			
		}

		else if(Name.equals("詞焼赤澗 塘斥獣蝿"))
		{
			System.out.println("\n\n詞焼赤澗 塘斥獣蝿 :  神神!! 貝戚亀研 岨 臣形 瑳猿?.\n\n");
			Thread.sleep(1500);
			System.out.println("詞焼赤澗 塘斥獣蝿税 貝戚亀亜 雌渋馬心柔艦陥.\n\n");
			Thread.sleep(1500);
			System.out.println("詞焼赤澗 塘斥獣蝿税 因維径引 号嬢径戚 雌渋杯艦陥.\n\n");
			Thread.sleep(1500);

			Status[1] += 80;
			Status[2] += 80;

			return Status;
			
		}

		else if(Name.equals("昼穣 檎羨淫"))
		{
			System.out.println("\n\n昼穣 檎羨淫 :  切奄社鯵辞拭 旋微 鎧遂拭 企背 霜庚背左畏柔艦陥.\n\n");
			Thread.sleep(1500);
			System.out.println("昼穣 檎羨淫戚 苑苑馬惟 閏奄 獣拙馬心柔艦陥.\n\n");
			Thread.sleep(1500);
			System.out.println("昼穣 檎羨淫戚 耕団 劾菌艦陥!\n\n");
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