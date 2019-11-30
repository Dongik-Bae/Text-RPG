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
		Status[0] = a; // ü��
		Status[1] = b; // ����
		Status[2] = c; // ���
		Status[3] = d; // ���
		Status[4] = e; // ����
		Status[5] = f; // �ִ�ü��
		Status[6] = g; // ���
		Status[7] = h; // ����
		MonsterName = Name;
		
	}

	public static int[][][] MetBoss(int[][][] User) throws InterruptedException, IOException
	{	BossEncounter = Hunt.Finish;

		if (BossEncounter == 0)
		{
			Boss Gs = new Boss(200, 30, 10, 1000000000,40,0,20,5, "C�� �� �ִ� ��������");
			System.arraycopy(Gs.Battle(User),0,User,0,User.length);
		}
		
		else if(BossEncounter == 1)
		{
			Boss TOEIC = new Boss(400, 100, 60, 1000000000,80,0,500,10, "����ִ� ���ͽ���");
			System.arraycopy(TOEIC.Battle(User),0,User,0,User.length);
		}

		else if(BossEncounter == 2)
		{
			Boss MM = new Boss(800, 300, 100, 1000000000,120,0,500,10, "��� ������");
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

			System.out.printf("Boss %d : %s��(��) ��� ������ �� �ֽ��ϴ�.", BossEncounter + 1,MonsterName);

			Thread.sleep(3000);
			intro = 1;
		}

		else
	{

		System.out.printf("\n����� %s��(��) �����ߴ�!", MonsterName);
		while(true)
		{
			System.out.printf("\n(%s LV : %d, ü�� : %d, ���ݷ� %d)\n",MonsterName,Status[7],Status[0],Status[1]);
			System.out.println("\n������ �Ͻðڽ��ϱ�?\n���� : 1, ���� : 2, ������ : 3");	
			int  i = input.nextInt();

			if (i == 1)
			{
				Status[0] -= DamageCalculation(User[0][6][1], Status[2]);
					
				System.out.printf("\n����� %s��(��) �����մϴ�.\n",MonsterName);
					
				if (Status[0] > 0)
				{
					System.out.printf("(%s ü�� : %d)\n", MonsterName,Status[0]);
					Thread.sleep(1500);
				}
				else
				{
					System.out.printf("(%s ü�� : 0)\n", MonsterName);
					Thread.sleep(1500);
				}

				if (Status[0] <= 0)
				{	
					Meant(MonsterName);

					System.out.printf("\n����� %s���Լ� �¸��ߴ�!\n", MonsterName);
					System.out.printf("(���� +%d, ��� +%d)\n\n", Status[4], Status[6]);
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

				System.out.printf("\n%s��(��) ����� �����մϴ�.\n\n", MonsterName);
				Thread.sleep(500);
				
				String Sentence = RandomSentence(MonsterName);
				System.out.printf("���ϰ� �ʹٸ� 5�� �ȿ� Ŀ�ǵ带 �Է��ϼ���. (Ŀ�ǵ� : %s)\n\n", Sentence);
				long start = System.currentTimeMillis();

				String err = input.nextLine();
				String commend = input.nextLine();
				
				long end = System.currentTimeMillis();
				
				if(commend.equals(Sentence) && (end - start)<5000)
				{
					System.out.println("\n\nȸ�� ����!\n\n");
					Thread.sleep(1500);
				}

				else
				{
					System.out.println("\n\nȸ�� ����...\n\n");	
					Thread.sleep(1500);
					
					User[0][0][0] -= DamageCalculation(Status[1], User[0][6][2]);
					User[0][6][0] -= DamageCalculation(Status[1], User[0][6][2]);
					

					if (User[0][6][0] > 0)
					{
						System.out.printf("(����� ü�� : %d)\n", User[0][6][0]);
						Thread.sleep(1500);
					}
					else
					{
						System.out.printf("(����� ü�� : 0)\n");
						Thread.sleep(1500);
					}

					if (User[0][6][0] <=0)
					{
						System.out.printf("\n%s��(��) ����� óġ�߽��ϴ�.\n\n",MonsterName);
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
					System.out.println("\n���� ����!.\n"); break;	
				}
				else
				{	Thread.sleep(1500);
					System.out.println("\n���� ����!");
					System.out.printf("%s��(��) ����� �����մϴ�.\n",MonsterName);

					User[0][0][0] -= DamageCalculation(Status[1], User[0][6][2]);
					User[0][6][0] -= DamageCalculation(Status[1], User[0][6][2]);
					
						
					System.out.printf("(����� ü�� : %d)\n", User[0][6][0]);
					Thread.sleep(1500);

					if (User[0][6][0] <=0)
					{
						System.out.printf("\n%s��(��) ����� óġ�߽��ϴ�.\n\n",MonsterName);
						intro = 0;
						P2counter = 0;
						break;
					}		
				}
			}		
				
			if(i == 3)
			{
					
				System.arraycopy(hunt.UsingItem(User),0,User,0,User.length);	

				System.out.printf("\n%s�� ����� �����մϴ�.\n", MonsterName);
				Thread.sleep(1500);

				User[0][0][0] -= DamageCalculation(Status[1], User[0][6][2]);
				User[0][6][0] -= DamageCalculation(Status[1], User[0][6][2]);
				

				if (User[0][6][0] > 0)
				{
					System.out.printf("(����� ü�� : %d)\n", User[0][6][0]);
				}
				else
				{
					System.out.printf("(����� ü�� : 0)\n");
				}

				if (User[0][6][0] <=0)
				{
					System.out.printf("\n%s��(��) ����� óġ�߽��ϴ�.\n\n",MonsterName);
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

		if (a < p1 && Name.equals("����ִ� ���ͽ���")) Sentence = "Life is Dramatic";
		else if (a < p1 && Name.equals("C�� �� �ִ� ��������")) Sentence = "V=IR";
		else if (a < p1 && Name.equals("��� ������")) Sentence = "���� ����� �������� 3�� �� �峲���� �¾...";

		else if (a < p2 && Name.equals("����ִ� ���ͽ���")) Sentence = "Life is Traumatic";
		else if (a < p2 && Name.equals("C�� �� �ִ� ��������")) Sentence = "I(t)=CdV(t)/dt";
		else if (a < p2 && Name.equals("��� ������")) Sentence = "�� �¿���� '������ ����'�Դϴ�.";

		else if (a < p3 && Name.equals("����ִ� ���ͽ���")) Sentence = "Freezing Cold Shatters My Sorrow";
		else if (a < p3 && Name.equals("C�� �� �ִ� ��������")) Sentence = "H=Ia^2/2(a^2+z^2)^(3/2)";
		else if (a < p3 && Name.equals("��� ������")) Sentence = "�� ����� ���� ������ ����!";

		else if (a < p4 && Name.equals("����ִ� ���ͽ���")) Sentence = "Scorching Sand Put It Together Again";
		else if (a < p4 && Name.equals("C�� �� �ִ� ��������")) Sentence = "F=ma, W=Fd, P=dW/dt";
		else if (a < p4 && Name.equals("��� ������")) Sentence = "�������������� ��������, �������������� �������";

		
		else Sentence = "Miss";
		
		return Sentence;

	}



	public static void Meant(String Name) throws InterruptedException, IOException
	{
		if (Name.equals("C�� �� �ִ� ��������") && intro == 0)
		{	
			DDD();

			System.out.printf("\n??? : ��濡");
			Thread.sleep(750);
			System.out.printf(" C�����ڰ� �ִ�...");
			Thread.sleep(750);
			System.out.println("\n\n");

			Thread.sleep(1500);

			System.out.printf("      �ʵ�");
			Thread.sleep(1000);
			System.out.printf(" �� �׷��� �� �ž�...");
			Thread.sleep(1000);
			System.out.println("\n\n");

			DDD();
		}	

		else if(Name.equals("C�� �� �ִ� ��������") && intro == 1)
		{
			System.out.printf("\n\n\nC�� �� �ִ� �������� :  ����...");

			Thread.sleep(1500);

			System.out.printf("�� ������ A��...\n\n");
			DDD();
		}

		else if (Name.equals("����ִ� ���ͽ���") && intro == 0)
		{	
			DDD();

			System.out.printf("\n??? : ����� ");
			Thread.sleep(750);
			System.out.printf("�ϰ� �ʹٰ�...?");
			Thread.sleep(750);
			System.out.println("\n\n");

			Thread.sleep(1500);

			System.out.printf("     �� ��������");
			Thread.sleep(1000);
			System.out.printf(" �ߵ� �ϰڱ�");
			Thread.sleep(1000);
			System.out.printf(" ��");
			Thread.sleep(1000);
			System.out.printf("����");
			Thread.sleep(800);
			System.out.printf("������");
			Thread.sleep(600);
			System.out.printf("��������");
			Thread.sleep(400);
			System.out.printf("����������");
			Thread.sleep(200);
			System.out.printf("������������");
			Thread.sleep(100);
			System.out.printf("��������������");
			Thread.sleep(50);
			System.out.println("\n\n");

			DDD();
		}	

		else if(Name.equals("����ִ� ���ͽ���") && intro == 1)
		{
			System.out.printf("\n\n\n����ִ� ���ͽ��� :  LC, RC");

			Thread.sleep(1500);

			System.out.printf(" ��� �����̱���!\n\n");
			DDD();
		}

		else if (Name.equals("��� ������") && intro == 0)
		{	
			DDD();

			System.out.printf("\n??? : ���� ������ ");
			Thread.sleep(750);
			System.out.printf("��������...");
			Thread.sleep(750);
			System.out.println("\n\n");

			Thread.sleep(1500);

			System.out.printf("      �ڱ�Ұ���");
			Thread.sleep(1000);
			System.out.printf(" ���ֽǷ���?");
			Thread.sleep(1000);
			System.out.println("\n\n");

			DDD();
		}	

		else if(Name.equals("��� ������") && intro == 1)
		{
			System.out.printf("\n\n\n��� ������ : ���� ���� ");
			Thread.sleep(1500);
			System.out.printf(" ����ϼ���...\n\n");
			Thread.sleep(1500);
			DDD();
		}



		else;	

	}

	public static int[] Pase2(int[] Status, String Name) throws InterruptedException, IOException
	{
		if(Name.equals("C�� �� �ִ� ��������"))
		{
			System.out.println("\n\nC�� �� �ִ� ���������� ���°� ���մϴ�.\n\n");
			Thread.sleep(1500);
			System.out.println("C�� �� �ִ� ���������� �г��Ͽ����ϴ�.\n\n");
			Thread.sleep(1500);
			System.out.println("C�� �� �ִ� ���������� ���ݷ°� ������ ����մϴ�.\n\n");
			Thread.sleep(1500);

			Status[1] += 40;
			Status[2] += 40;

			return Status;
			
		}

		else if(Name.equals("����ִ� ���ͽ���"))
		{
			System.out.println("\n\n����ִ� ���ͽ��� :  ����!! ���̵��� �� �÷� ����?.\n\n");
			Thread.sleep(1500);
			System.out.println("����ִ� ���ͽ����� ���̵��� ����Ͽ����ϴ�.\n\n");
			Thread.sleep(1500);
			System.out.println("����ִ� ���ͽ����� ���ݷ°� ������ ����մϴ�.\n\n");
			Thread.sleep(1500);

			Status[1] += 80;
			Status[2] += 80;

			return Status;
			
		}

		else if(Name.equals("��� ������"))
		{
			System.out.println("\n\n��� ������ :  �ڱ�Ұ����� ���� ���뿡 ���� �����غ��ڽ��ϴ�.\n\n");
			Thread.sleep(1500);
			System.out.println("��� �������� ����ϰ� ���� �����Ͽ����ϴ�.\n\n");
			Thread.sleep(1500);
			System.out.println("��� �������� ���� ���ݴϴ�!\n\n");
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