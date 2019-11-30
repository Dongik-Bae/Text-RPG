import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Hunt
{
	static int lightening=0;//����
	static int key=0;//ȣ�ݿ��� Ȳ�ݿ���
	static boolean floor2 = false;//2�� �ö󰡱�

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
						## ������ ���ڴ� ���� �̸�
		
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
			System.out.printf("   �̸�  :  %-16s   ����  : %s (��� + %d)\n", Name, Index(User[0][1][8]), User[0][1][2]);
			System.out.printf("   LV    :  %-16d   ����  : %s (��� + %d)\n", User[0][6][7], Index(User[0][2][8]), User[0][2][2]);
			System.out.printf("   ü��  :  %-3d/%-12d   ����  : %s (��� + %d)\n", User[0][6][0],User[0][6][5],Index(User[0][3][8]), User[0][3][2]);
			System.out.printf("   ����  :  %-16d   �Ź�  : %s (��� + %d)\n", User[0][6][1], Index(User[0][4][8]), User[0][4][2]);
			System.out.printf("   ���  :  %-16d   ����  : %s (���� + %d)\n", User[0][6][2], Index(User[0][5][8]), User[0][5][1]);
			System.out.printf("   ���  :  %-16d\n", User[0][6][3]);
			System.out.printf("   ����  :  %-3d/%-16d\n", User[0][6][4], pibonachi(User[0][0][7]));
			System.out.printf("   ���  :  %-16d\n\n\n", User[0][6][6]);


			System.arraycopy(Move(User), 0 , User, 0, User.length);
			Thread.sleep(1000);
			System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
			
			if (User[0][6][0] <= 0)
			{
				System.out.print("\n\nYOU");
				Thread.sleep(1000);				
				System.out.print(" DIED");
				Thread.sleep(2000);

				System.out.println("\n\n\n\n��Ȱ�Ͻðڽ��ϱ�? ��:1, �ƴϿ�:2");
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
				System.out.println("\n\n������ �¾Ҵ�! ü���� �����մϴ�.(-20)\n\n");
				lightening = 0;
				Thread.sleep(800);
				User[0][0][0]-=20;
			}

			if (Finish == 3)
			{	DotLine();
				Thread.sleep(1500);
				System.out.println("\n\nGame Clear!\n\n");	
				Thread.sleep(1500);
				System.out.println("\n\n�÷������ּż� �����մϴ�.\n\n");
				Thread.sleep(1500);
				System.out.println("\n\n-- ������ --\n\n");
				Thread.sleep(1500);
				System.out.println("\n\n������ �赿�� ������\n\n");
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
		System.out.println("\n����� �����濡 �����߽��ϴ�. ���� ���ðڽ��ϱ�?\n");
			
		if (a==0)
		{
			System.out.println("  ��     ���� : 1,  �� : 2, ������ : 3\n���ࢺ");
			while(true)
			{
				String i =input.nextLine();
				if (i.equals("1") || i.equals("2") || i.equals("3")) break;
				else System.out.println("\n�� �� ���� �����Դϴ�.\n");
			}
		}	
			
		else if (a==1)
		{
			System.out.println("���ࢺ     ���� : 1, ������ : 3");
			while(true)
			{
				String i =input.nextLine();
				if (i.equals("1") || i.equals("3")) break;
				else System.out.println("\n�� �� ���� �����Դϴ�.\n");
			}			
		}	
		else if (a==2)
		{
			System.out.println("  ��     ���� : 1, �� : 2\n����");
			while(true)
			{
				String i =input.nextLine();
				if (i.equals("1") || i.equals("2")) break;
				else System.out.println("\n�� �� ���� �����Դϴ�.\n");
			}	
		}		
		else if (a==3)
		{
			System.out.println("  ��     �� : 2, ������ : 3\n  �ࢺ");
			while(true)
			{
				String i =input.nextLine();
				if (i.equals("2") || i.equals("3")) break;
				else System.out.println("\n�� �� ���� �����Դϴ�.\n");
			}
		}

		System.out.println("\n\n������ ���迡 ���� ����� ��...");
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
	
		System.out.print("\n\n\n���⿡ ����� �̸��� �����ּ��� : ");
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
		
		System.out.println("\n������ �Ͻðڽ��ϱ�?\n1. �̵�  2. ����  3. ������  4.����/�ҷ�����  5. ����");
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
			System.out.println("\n\n�ϰ��� �ϴ� �ൿ�� �Է����ּ���\n1. ����\n2. �ҷ�����");

			while(true)
			{
				String SaveLoad = input.nextLine();
				if (SaveLoad.equals("1"))
				{
					Save(User);
					System.out.println("\n���忡 �����߽��ϴ�.");
					break;
				}
				else if (SaveLoad.equals("2"))
				{
					System.arraycopy(Load(User),0,User,0,User.length);
					System.out.println("\n�ҷ����⿡ �����߽��ϴ�.");
					break;
				}
				else System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���");
			}	
		}
		if(i == 5)
		{	DotLine();
			System.out.println("\n\n�̸� : ����� �̸��Դϴ�.");
			System.out.println("LV   : ����, ���������� ������ ���͸� �����Ե˴ϴ�.");
			System.out.println("ü�� : 0�� �Ǹ� �׽��ϴ�.");
			System.out.println("���� : �ش� ��ġ��ŭ ���Ϳ��� ������� �ݴϴ�.");
			System.out.println("��� : ���ظ� ���� �� �ش� ��ġ��ŭ ���ظ� ���Դϴ�.");
			System.out.println("��� : �ö󰥼��� ���� ������, �̷ο� �̺�Ʈ �߻� Ȯ���� �����մϴ�.");
			System.out.println("���� : ���͸� ����ϸ� ȹ���մϴ�. ��ǥ�� �޼��ϸ� �������մϴ�.");
			System.out.println("��� : ���ӿ��� ���Ǵ� ��ȭ�Դϴ�.");
			System.out.println("\n\n(��������� ���� : ü�� -= ���� * ( 1 - ( ��� / ( ��� + 50 ) ) )");
			System.out.println("\n\n����� ��ǥ : �������� ???�� ����ϴ� ��");
			System.out.printf("\n������������ ���� ������ �� : %d\n\n", 2-Finish);
			System.out.println("\n������ ������ 1�� �Է��ϼ��� :  ");
			String Error = input.nextLine();
			String exit = input.nextLine();
			while (true)
			{
				if(exit.equals("1")) break;
				else System.out.println("�߸��� �Է��Դϴ�.");
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
			
			System.out.println("\n\n������ ��ðڽ��ϱ�?");
			System.out.println("0. �԰Ÿ�\n1. ����\n2. ����\n3. ����\n4. �Ź�\n5. ����\n6. ���� ���ΰ� ��ȭ\n7. ������");
			int  i = input.nextInt();
			 
			if(((i == 7) && (Math.random()<=0.4)) && !(floor2))
			{
					System.out.println("\n\n???  :  �� ������ 2���� �ִ� �� �˰� �ֳ�?......\n\n\t�б��� ������Ʈ�� ȣ�ݿ찡 ���� ����Ÿ�����.\n\t(�������� 8�� �������ÿ�)\n\n\t");
					floor2 = true;
					break;
			}
	
			if((i == 7) && (Math.random()<=0.4))
			{
				System.out.println("\n\n???  :  ���. �ű� �ڳ�\n\n\tü���� ���غ��̴µ� �̰� �����ϴ� �� ���?\n\n\t������ �ִ� ��ȸ�� �ƴϾ�.\n\n");
				Thread.sleep(800);
				System.out.println("0. �� �԰� ��⵵ ����ϴ�. 1. �� �� ���ƿ�.(30 Gold)");
				int i1=input.nextInt();
				Thread.sleep(800);
			
			if (i1 == 0)
			{	
				System.out.println("\n\n??? : ����...���ٰ� �����̳� �¾ƶ�!\n\n");
				lightening++;
			}	
	
			if (i1 == 1)
			{
				if(User[0][0][6]>=20)	{	
					System.out.println("\n\n???  :  ���� �� ���� �����״� �� �����ϰ�.\n\n");
					Thread.sleep(1000);
					User[0][0][6] -= 20;	
					System.out.println("\n\nȣ�ݿ��� Ȳ�ݿ��踦 �����!\n\n");
					Thread.sleep(800);
					key++;
				}
				else	{
					System.out.println("\n\n??? : ���� �����鼭 ����������? ���ٰ� �����̳� �¾ƶ�!\n\n");
					lightening++;
				}
			}

			

		}
			if (i == 0)
			{
				System.out.println("\n\n���ϴ� �԰Ÿ��� �����ϼ���.");
				System.out.println("1. Ŀ�� (3 Gold)\n2. �ܹ��� ���� ��� (10 Gold)\n3. ��븮�� ����Ƣ�� (20 Gold)\n4. ������ �׾�� (40 Gold)\n5. �������� ��� (10000000 Gold)");
				j = input.nextInt();

				if (j == 1)
				{
					System.out.print("\n\n�� ���� �����Ͻðڽ��ϱ�? : ");
					HowMany = input.nextInt();
					if (HowMany<1)
					{
						System.out.println("\n\n�ڿ����� �Է����ּ���.\n\n");
						break;		
					}
		 			if (User[0][0][6] - 3*HowMany >= 0)
					{
						User[0][0][6] -= 3*HowMany;
						User[1][0][0] += HowMany;
						System.out.printf("\n\nĿ�Ǹ� %d�� �����߽��ϴ�. (- %d Gold)\n\n", HowMany, HowMany*3);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
					}
					
				}			
				if (j == 2)
				{
					System.out.print("\n\n�� ���� �����Ͻðڽ��ϱ�? : ");
					HowMany = input.nextInt();
					if (HowMany<1)
					{
						System.out.println("\n\n�ڿ����� �Է����ּ���.\n\n");
						break;		
					}	
					if (User[0][0][6] - 10*HowMany >= 0)
					{
						User[0][0][6] -= 10*HowMany;
						User[1][0][1] += HowMany;
						System.out.printf("\n\n�ܹ��� ���� ����� %d�� �����߽��ϴ�. (- %d Gold)\n\n", HowMany, HowMany*10);
						Thread.sleep(800);
						System.out.println("\n\nȭ��ǿ��� �Ա� �� ���� ����̴�!!!\n\n");
						Thread.sleep(800);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
					}
					
				}			
				if (j == 3)
				{
					System.out.print("\n\n�� ������ �����Ͻðڽ��ϱ�? : ");
					HowMany = input.nextInt();
					if (HowMany<1)
					{
						System.out.println("\n\n�ڿ����� �Է����ּ���.\n\n");
						break;		
					}	
		 			if (User[0][0][6] - 20*HowMany >= 0)
					{
						User[0][0][6] -= 20*HowMany;
						User[1][0][2] += HowMany;
						System.out.printf("\n\n��븮�� ����Ƣ���� %d���� �����߽��ϴ�. (- %d Gold)\n\n", HowMany, HowMany*20);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
					}
					
				}
				if (j == 4)
				{
					System.out.print("\n\n�� ���� �����Ͻðڽ��ϱ�? : ");
					HowMany = input.nextInt();
					if (HowMany<1)
					{
						System.out.println("\n\n�ڿ����� �Է����ּ���.\n\n");
						break;		
					}	
		 			if (User[0][0][6] - 40*HowMany >= 0)
					{
						User[0][0][6] -= 40*HowMany;
						User[1][0][3] += HowMany;
						System.out.printf("\n\n������ �׾�̸� %d�� �����߽��ϴ�. (- %d Gold)\n\n", HowMany, HowMany*40);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
					}
					
				}
				if (j == 5)
				{
					System.out.print("\n\n??? : �� ��. �� �� ����. ���ư�");
					Thread.sleep(800);
					System.out.println("\n\n������ �����մϴ�.\n\n");
				}			
			
			}

			if (i == 1)
			{
				int[] Suncap = {0,0,10,1,0,0,0,0,-1001};
				int[] Healm = {0,0,20,2,0,0,0,0,-1002};
				int[] Snapback = {0,0,40,3,0,0,0,0,-1003};

				System.out.println("\n\n���ϴ� ��� �����ϼ���.");
				System.out.println("1. �̽����� ��ĸ (5 Gold)\n2. ��κ�ĸ (10 Gold)\n3. ������ (25 Gold)");
				j = input.nextInt();

				if (j == 1)
				{
					HowMany = 1;
					
		 			if (User[0][0][6] - 5*HowMany >= 0)
					{
						User[0][0][6] -= 5*HowMany;
						System.arraycopy(Suncap, 0, User[0][1],0,Suncap.length);	
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n�̽����� ��ĸ�� �����߽��ϴ�. (- %d Gold)\n\n", HowMany*5);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
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
						System.out.printf("\n\n��κ�ĸ�� �����߽��ϴ�. (- %d Gold)\n\n", HowMany*10);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
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
						System.out.printf("\n\n�������� �����߽��ϴ�. (- %d Gold)\n\n", HowMany*25);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
					}
					
				}		
			}

			if (i == 2)
			{
				int[] Tshirt = {0,0,10,1,0,0,0,0,-2001};
				int[] Sweater = {0,0,20,2,0,0,0,0,-2002};
				int[] Jacket = {0,0,40,3,0,0,0,0,-2003};

				System.out.println("\n\n���ϴ� ��� �����ϼ���.");
				System.out.println("1. �� �þ Ƽ���� (5 Gold)\n2. �ɱ׶�� ������ (10 Gold)\n3. ������ ���� (20 Gold)");
				j = input.nextInt();

				if (j == 1)
				{
					HowMany = 1;
					
		 			if (User[0][0][6] - 5*HowMany >= 0)
					{
						User[0][0][6] -= 5*HowMany;
						System.arraycopy(Tshirt, 0, User[0][2],0,Tshirt.length);	
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n�� �þ Ƽ������ �����߽��ϴ�. (- %d Gold)\n\n", HowMany*5);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
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
						System.out.printf("\n\n�ɱ׶�� �����͸� �����߽��ϴ�. (- %d Gold)\n\n", HowMany*10);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
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
						System.out.printf("\n\n������ ������ �����߽��ϴ�. (- %d Gold)\n\n", HowMany*20);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
					}
					
				}			
			}

			if (i == 3)
			{
				int[] Training = {0,0,10,1,0,0,0,0,-3001};//ü���� �ݹ���
				int[] Jean = {0,0,30,2,0,0,0,0,-3002};//������ û����
				int[] NewJean = {0,0,30,2,0,0,0,0,-3003};//�� Ŭ���� ���� �������� ��
				int[] PsyPants = {0,0,60,2,0,0,0,0,-3003};//������ ���ȹ���
				
				System.out.println("\n\n���ϴ� ��� �����ϼ���.");			
				System.out.println("1. ü���� �ݹ��� (5 Gold)\n2. ������ û���� (10 Gold)\n3. �� Ŭ���� ���� �������� �� ( 20 Gold)\n4. ������ ���ȹ��� ( 40 Gold)");
				j = input.nextInt();

				if (j == 1)
				{
					HowMany = 1;
					
		 			if (User[0][0][6] - 5*HowMany >= 0)
					{
						User[0][0][6] -= 5*HowMany;
						System.arraycopy(Training, 0, User[0][3],0,Training.length);
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\nü���� �ݹ����� �����߽��ϴ�. (- %d Gold)\n\n", HowMany*5);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
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
						System.out.printf("\n\n������ û������ �����߽��ϴ�. (- %d Gold)\n\n", HowMany*10);
					}	
						else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
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
						System.out.printf("\n\n�� Ŭ���� ���� �������� ���� �����߽��ϴ�. (- %d Gold)", HowMany*20);
						Thread.sleep(1500);
						System.out.println("\n\n���� ���� : �װ� �׳� ������ û������. ���� ����� �� ������ �� �ȸ���. \n\n�� ���� ������ ��� ��ǰ�� ����� �ٲ����?\n\n");
						Thread.sleep(2000);
						System.out.println("\n\n�ӾҴ�......\n\n");
						Thread.sleep(1500);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
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
						System.out.printf("\n\n������ ���ȹ����� �����߽��ϴ�. (- %d Gold)\n\n", HowMany*40);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
					}
					
				}
			}

			if (i == 4)
			{
				
				int[] Slippers = {0,0,10,1,0,0,0,0,-4001};//�Ｑ ������
				int[] Sneakers = {0,0,20,2,0,0,0,0,-4002};//�� �ȭ
				int[] RollerSkates = {0,0,40,3,0,0,0,0,-4003};//�ѷ�������Ʈ
				int[] Shoes = {0,0,60,4,0,0,0,0,-4004};//50cm ��â ����

				System.out.println("\n\n���ϴ� ��� �����ϼ���.");			
				System.out.println("1. �Ｑ ������ (10 Gold)\n2. �� �ȭ (20 Gold)\n3. �ѷ� ������Ʈ (30 Gold)\n4. 50cm ��â ���� (40 Gold)");
				j = input.nextInt();

				if (j == 1)
				{
					HowMany = 1;
					
		 			if (User[0][0][6] - 10*HowMany >= 0)
					{
						User[0][0][6] -= 10*HowMany;
						System.arraycopy(Slippers, 0, User[0][4],0,Slippers.length);
					
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n�Ｑ �����۸� �����߽��ϴ�. (- %d Gold)\n\n", HowMany*10);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
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
						System.out.printf("\n\n�� �ȭ�� �����߽��ϴ�. (- %d Gold)\n\n", HowMany*20);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
					}
				if (j == 3)
				{
					HowMany = 1;
					
		 			if (User[0][0][6] - 30*HowMany >= 0)
					{
						User[0][0][6] -= 30*HowMany;
						System.arraycopy(RollerSkates, 0, User[0][4],0,RollerSkates.length);
					
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n�ѷ� ������Ʈ�� �����߽��ϴ�. (- %d Gold)\n\n", HowMany*30);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
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
						System.out.printf("\n\n50cm ��â ���θ� �����߽��ϴ�. (- %d Gold)\n\n", HowMany*40);
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
					}
					
				}
			}

			if (i == 5)
			{
				int[] Umbrella = {0,20,0,0,0,0,0,0,-5001};
				int[] Book = {0,50,0,0,0,0,0,0,-5002};
				int[] LighteningRod = {0,70,0,0,0,0,0,0,-5003};//1ȣ�� ������ �Ƿ�ħ
				int[] Scholarship = {0,100,0,0,0,0,0,0,-5004};//��ž�� ��������

				System.out.println("\n\n���ϴ� ��� �����ϼ���.");
				System.out.println("1. ���� (40 Gold)\n2. �β��� ����å (80 Gold)\n3. 1ȣ�� ������ �Ƿ�ħ (130 Gold)\n4. ��ž�� �������� (250 Gold)");
				j = input.nextInt();

				if (j == 1)
				{
					HowMany = 1;
					
					if (User[0][0][6] - 40*HowMany >= 0)
					{
						User[0][0][6] -= 40*HowMany;
						
						System.arraycopy(Umbrella, 0, User[0][5],0,Umbrella.length);
					
						System.arraycopy(ApplyStatus(User), 0, User,0,User.length);
						System.out.printf("\n\n������ �����߽��ϴ�. (- %d Gold)\n\n", HowMany*40);	
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
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
						System.out.printf("\n\n�β��� ����å�� �����߽��ϴ�. (- %d Gold)\n\n", HowMany*80);				
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
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
						System.out.printf("\n\n1ȣ�� ������ �Ƿ�ħ�� �����߽��ϴ�. (- %d Gold)\n\n", HowMany*130);					
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
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
						System.out.printf("\n\n��ž�� ���������� �����߽��ϴ�. (- %d Gold)\n\n", HowMany*250);					
					}	
					else
					{
						System.out.println("\n\n��尡 �����մϴ�.\n\n");
					}
				}		
			}

			if (i == 7)
			{
				System.out.println("\n\n\n�������� �����ϴ�.");				
				break;
			}
			
			if (i == 8)
			{
				if (floor2)
				{
					Thread.sleep(800);
					System.out.println("\n\n\n������ ������ 2������ �ö�Խ��ϴ�.\n\n");
					Thread.sleep(800);
					System.out.println("\n\nȣ�ݿ��� �ݰ� ������ �ֽ��ϴ�. Ȳ�ݿ��踦 ����Ͻðڽ��ϱ�?\n\n");
					Thread.sleep(800);
					System.out.println("\n\n1. ����Ѵ�. 2. ������� �ʴ´�.\n\n");
					int a=input.nextInt();

					if( a == 1 && key>=1)
					{
						System.out.println("\n\nȣ�ݿ��� �ູ���� �ִ�ü���� 10 �����Ͽ����ϴ�\n\n");
						Thread.sleep(800);
						User[0][0][5] += 10;
					}

					else if ( a == 1 && key ==0 ) System.out.println("\n\nȲ�ݿ��谡 ����.\n\n");
					else System.out.println("\n\n������ ����� ���� �ƴϾ�.\n\n");
							
				}
			
			}

			if (i == 6)
			{
				System.out.println("\n\n����, ���� �� ����?\n\n");
				Thread.sleep(800);
				System.out.println("\n\n1. ���� ������ �� ���׿�.  2. ���Կ�. �ȳ��� �輼��.\n\n");

				int option=input.nextInt();

				if (option == 1)
				{
					System.out.println("\n\n�̼����� �ڿ��� �� �� ���̴�?\n\n");
					Thread.sleep(800);
					System.out.println("\n\n(...���� �� ���Ѵ�.)\n\n");
					Thread.sleep(800);
				}

				else if (option == 2)
				{
					System.out.println("\n\n\n��� ��ٷ���. �ڳ� ���� �� ���� �����.\n\nĿ�� �� �� ���ð� ����.\n\n");
					Thread.sleep(800);
					System.out.println("\n\n1. �̹� �� �� ���̾��.  2. �����մϴ�.\n\n");
					Thread.sleep(800);
						int option1=input.nextInt();
						if( option1 == 1)
						{
							System.out.println("\n\n�׷��ٸ��...\n\n");
						}
						else if( option1 == 2)
						{
								User[1][0][1] += 1;
								System.out.println("\n\n���� ���� ������. 1 Gold��.\n\n");
								Thread.sleep(800);
								if(User[0][0][6]<=0)	{System.out.println("\n\n���� ������. ������ �ٽ� ����. ����.\n\n");}
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
		System.out.println("-- ��� ������ ������ ��� --");
		if (User[1][0][0] == 0 && User[1][0][1] == 0 && User[1][0][2] == 0 && User[1][0][3] == 0)
		{

			NoItem = 1;
		}
		
		else
		{	NoItem = 0;
			if (User[1][0][0] > 0) System.out.printf("\n1. Ŀ�� : %d��", User[1][0][0]);
			if (User[1][0][1] > 0) System.out.printf("\n2. �ܹ��� ���� ��� : %d��", User[1][0][1]);
			if (User[1][0][2] > 0) System.out.printf("\n3. ��븮�� ����Ƣ�� : %d����", User[1][0][2]);
			if (User[1][0][3] > 0) System.out.printf("\n4. ������ �׾�� : %d��", User[1][0][3]);
		}

		if (NoItem > 0)
		{
			System.out.println("\n\n����� �� �ִ� �������� �����ϴ�!");
			NoItem = 0;
		}
		else
		{
			System.out.println("\n\n\n������ ����Ͻðڽ��ϱ�? : ");
			int Item = input.nextInt();
			if (Item == 1 && User[1][0][0] > 0)
			{
				User[1][0][0] -=1;
				if (User[0][0][0] + 5 > User[0][0][5])
				{
					System.out.printf("ü���� ȸ���Ͽ����ϴ�. (%d->%d)\n\n", User[0][0][0], User[0][0][5]);
					User[0][0][0] = User[0][0][5];
				}
				else
				{
					System.out.printf("ü���� ȸ���Ͽ����ϴ�. (%d->%d)\n\n", User[0][0][0], User[0][0][0]+5);
					User[0][0][0] += 5;
				}
				
				System.arraycopy(ApplyStatus(User), 0, User,0,User.length);				

			}
			else if (Item == 2&& User[1][0][1] > 0)
			{
				User[1][0][1] -=1;
				if (User[0][0][0] + 15 > User[0][0][5])
				{
					System.out.printf("ü���� ȸ���Ͽ����ϴ�. (%d->%d)\n\n", User[0][0][0], User[0][0][5]);
					User[0][0][0] = User[0][0][5];
				}
				else
				{
					System.out.printf("ü���� ȸ���Ͽ����ϴ�. (%d->%d)\n\n", User[0][0][0], User[0][0][0]+10);
					User[0][0][0] += 15;
				}
				
				System.arraycopy(ApplyStatus(User), 0, User,0,User.length);				

			}
			else if (Item == 3&& User[1][0][2] > 0)
			{
				User[1][0][2] -=1;
				if (User[0][0][0] + 30 > User[0][0][5])
				{
					System.out.printf("ü���� ȸ���Ͽ����ϴ�. (%d->%d)\n\n", User[0][0][0], User[0][0][5]);
					User[0][0][0] = User[0][0][5];
				}
				else
				{
					System.out.printf("ü���� ȸ���Ͽ����ϴ�. (%d->%d)\n\n", User[0][0][0], User[0][0][0]+20);
					User[0][0][0] += 30;
				}
				
				System.arraycopy(ApplyStatus(User), 0, User,0,User.length);				

			}
			else if (Item == 4&& User[1][0][3] > 0)
			{
				User[1][0][3] -=1;
				if (User[0][0][0] + 50 > User[0][0][5])
				{
					System.out.printf("ü���� ȸ���Ͽ����ϴ�. (%d->%d)\n\n", User[0][0][0], User[0][0][5]);
					User[0][0][0] = User[0][0][5];
				}
				else
				{
					System.out.printf("ü���� ȸ���Ͽ����ϴ�. (%d->%d)\n\n", User[0][0][0], User[0][0][0]+40);
					User[0][0][0] += 50;
				}
				
				System.arraycopy(ApplyStatus(User), 0, User,0,User.length);				

			}
			else
			{
				System.out.println("\n\n���� �������Դϴ�!");
			}
		}
		return User;
	}

	
	public static String Index(int Num) throws InterruptedException, IOException
	{
		       if (Num == -1000) return "�㸧�� ����";
		else if (Num == -1001) return "�̽����� ��ĸ";
		else if (Num == -1002) return "��κ�ĸ";
		else if (Num == -1003) return "������";

		else if (Num == -2000) return "�㸧�� ����";
		else if (Num == -2001) return "��þ Ƽ����";
		else if (Num == -2002) return "�ɱ׶�� ������";
		else if (Num == -2003) return "������ ����";

		else if (Num == -3000) return "�㸧�� ����";
		else if (Num == -3001) return "ü���� �ݹ���";
		else if (Num == -3002) return "������ û����";
		else if (Num == -3003) return "����������";
		else if (Num == -3004) return "������ ���ȹ���";

		else if (Num == -4000) return "�㸧�� �Ź�";
		else if (Num == -4001) return "�Ｑ ������";
		else if (Num == -4002) return "�� �ȭ";
		else if (Num == -4003) return "�ѷ� ������Ʈ";
		else if (Num == -4004) return "50cm ��â ����";

		else if (Num == -5000) return "���� ������";
		else if (Num == -5001) return "����";
		else if (Num == -5002) return "�β��� ����å";
		else if (Num == -5003) return "�Ƿ�ħ";
		else if (Num == -5004) return "��ž�� ��������";
		else return "����";
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
				System.out.println("\n�ɷ�ġ�� ����մϴ�.");
				System.out.printf("\n�ִ�ü�� :  + %d", User[0][0][7] + MaxH);
				System.out.printf("\n����     :  + %d", Atk);
				System.out.printf("\n���     :  + %d", Arm);
				System.out.printf("\n���     :  + %d", Lck);
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
		if (RandomPlace == 0) System.out.println("*** ��ϴ� ���� ***");
		else if (RandomPlace == 1) System.out.println("*** IT 1ȣ�� ***");
		else if (RandomPlace == 2) System.out.println("*** IT 2ȣ�� ***");
		else if (RandomPlace == 3) System.out.println("*** IT 3ȣ�� ***");
		else if (RandomPlace == 4) System.out.println("*** ���а� �Ĵ� ***");
		else if (RandomPlace == 5) System.out.println("*** ������ ***");
		else if (RandomPlace == 6) System.out.println("*** �ʹ� ��Ÿ� ***");
		else if (RandomPlace == 7) System.out.println("*** ���� ���� ***");
		else if (RandomPlace == 8) System.out.println("*** ��Ȱ�� ���� ***");
		else if (RandomPlace == 8) System.out.println("*** ���� ***");
		else if (RandomPlace == 9) System.out.println("*** ������ ***");
		else if (RandomPlace == 10) System.out.println("*** ������ ���� ***");
		else if (RandomPlace == 11) System.out.println("*** �ó� ***");
		else System.out.println("*** ���μ��� ***");
	}































































	
}



















