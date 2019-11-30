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
		System.out.printf("��� �������� �����ֽ��ϴ�... �����Ͻðڽ��ϱ�? (������ 50���) \n\n");
		System.out.printf("�����Ѵ� : 1, ���� �ʴ´� : 2\n");
		int bat = 0;

		try
		{	
			int join = input.nextInt();
		
			if(join == 1 && User[0][0][6] > 50)
			{	User[0][0][6] -= 50;
				System.out.println("\n\n(������ -50���)");
				while(true)
				{
					System.out.printf("\n\n� ������ �ϰ� �����Ű���?\n\n");
					System.out.printf("Ȧ¦ : 1\n���������� : 2\n�ֻ��� �� ���߱� : 3\n");
					int select = input.nextInt();
			
					System.out.printf("\n\n�����Ͻ� �ݾ��� �������ּ���. (���� �ݾ� : %d)\n", User[0][0][6]);

					while(true)
					{
						bat = input.nextInt();
						if(User[0][0][6] < bat)
						{
							System.out.println("\n\n���� �� ���� ���̴� �� �� �����ϴ�.");
						}
						else 
						{
							System.out.printf("\n\n�׷� �����Ͻ� ������ �����ϰڽ��ϴ�.\n");
							break;
						}
					}
			
					if(select == 1)
					{
						System.out.printf("\n\nȦ�� ¦�߿��� �ϳ��� �������ּ���.");
						System.out.println("\n\nȦ : 1, ¦ : 2");
						int a3 = input.nextInt();
						int a4 = rd.nextInt(1)+1;
						if(a3 == a4)
						{
							System.out.printf("\n\n�¸�! (��� +%d)\n",bat * 2);
							User[0][0][6] += bat*2;
						}
					
						else
						{
							System.out.printf("\n\n�й�... (��� -%d)\n",bat);
							User[0][0][6] -= bat;
						}
				
					}

					else if (select == 2)
					{
						System.out.printf("\n\n���� ���� �� �߿� �ϳ��� �����Ͽ� ���ּ���.\n");
						System.out.printf("\n\n���� : 1, ���� : 2, �� : 3\n");
						int a6 = input.nextInt();
						int a7 = rd.nextInt(2)+1;
						if(a6==a7)
						{
							System.out.printf("\n\n���º�...\n");
						}
				
						else if(a6==1&&a7==2||a6==2&&a7==3||a6==3&&a7==1)
						{
							System.out.printf("\n\n�й�... (��� -%d)\n",bat);
							User[0][0][6] -= bat;
					
						}
						else if(a6==1&&a7==3||a6==2&&a7==1||a6==3||a7==2)
						{
							System.out.printf("\n\n�¸�! (��� +%d)\n",bat * 3);
							User[0][0][6] += bat*3;
						}
					}

					else if (select==3)
					{
						System.out.printf("\n\n1~6������ ���ڸ� �ϳ� �Է��Ͽ��ּ���.\n");
						int a8= input.nextInt();
						int a9 = rd.nextInt(6)+1;
				
						if(a8==a9)
						{
							System.out.printf("\n\n�¸�! (��� +%d)\n",bat * 6);
							User[0][0][6] += bat*6;
						}
						else
						{	
							System.out.printf("\n\n�й�... (��� -%d)\n",bat);
							User[0][0][6] -= bat;
						}
					}

					System.out.println("\n\n������ ����Ͻðڽ��ϱ�?");
					System.out.println("�� : 1, �ƴϿ� : 2");
					int end = input.nextInt();

					if (User[0][0][6] <= 0)
					{
						System.out.println("\n\n���� ��� �Ҿ����ϴ�. �����ǿ��� ������մϴ�.");
						break;
					
					}

					else if (end == 2) 
					{
						System.out.println("\n\n�����忡�� �����ϴ�.\n\n");
						break;
					}
					else System.out.println("\n\n������ ����մϴ�.");

				}
			}

			else if (join == 2) System.out.println("\n\n���� ������ �ʰ� �����ϴ�.");
			else if (User[0][0][6] <= 50) System.out.println("\n\n���� �����Ͽ� ������ �Ұ��մϴ�.");
			else System.out.println("\n\n�߸��� �Է��Դϴ�. �����忡�� ������մϴ�.");
		}
		catch(InputMismatchException ex)
		{
			System.out.println("\n\n�߸��� �Է��Դϴ�. �����ǿ��� ������մϴ�.");
			return User;
		}
		

		return User;
	}

	public static int[][][] Box(int[][][] User) throws InterruptedException, IOException
	{	Scanner input = new Scanner(System.in);
		try
		{
			System.out.println("\n\n���ڸ� �߰��߽��ϴ�. ���ðڽ��ϱ�?\n\n1. ��, 2. �ƴϿ�");
			int i = input.nextInt();
			if (i == 1)
			{
		
				int aa=rd.nextInt(100);//������ ������ �ο� ���� ���� �����ؾ���
				if(aa < 25)
				{		
					int bb = rd.nextInt(User[0][6][5] - User[0][6][3]);
					System.out.printf("\n\n���ڿ��� ���Ⱑ �������Խ��ϴ�.(ü�� -%d)\n",bb);
					User[0][0][0] -= bb;		

				}	
			
				else if(aa < 40)
				{
					int RP = rd.nextInt(10)+1;
					System.out.printf("���� �ȿ� Ŀ�ǰ� ����ֽ��ϴ�! (Ŀ�� +%d��)", RP);
					User[1][0][0] += RP;

				}

				else if(aa < 65)
				{
					int dd = rd.nextInt(User[0][6][3]) + 1;
					User[0][0][6] += dd;
					System.out.printf("\n\n���ڿ��� ��尡 ���Խ��ϴ�.(��� +%d)\n",dd);

				}
			
				else if(aa < 80)
				{
					System.out.printf("\n\n���Ͱ� ��Ÿ�����ϴ�!!!\n\n");
					Thread.sleep(1500);
					Fight fight = new Fight();
					System.arraycopy(fight.MetMonster(User), 0 ,User, 0, User.length);	
				}

				else System.out.println("\n\n���ڴ� �� ����ֽ��ϴ�...");

				return User;
			}
			
			else
			{
				System.out.println("\n\n���ڸ� ����Ĩ�ϴ�.");
				Thread.sleep(1500);
				return User;
			}
			
		
		}
		catch(InputMismatchException ex)
		{
			System.out.println("�߸��� �Է��Դϴ�. ���ڸ� ����Ĩ�ϴ�.");
			return User;
		}

		
	}

	public static int[][][] Shaman(int[][][] User) throws InterruptedException, IOException 
	{	Scanner input = new Scanner(System.in);
		try
		{
			System.out.println("\n������ ���ָӴϸ� �������ϴ�. ���� �Žðڽ��ϱ�??\n\n");
			System.out.println("\n���� �Ǵ� : 1, ���� ���� �ʴ´� : 2\n");
			int a1 = input.nextInt();
			if(a1==1)
			{
				System.out.println("ȣȣȣ �����ڿ� ���� ���⸦ ���ϴ°�?\n");
				System.out.println("���� ���⸦ ���Ѵ� :1, ��ġ �ʴ´� : 2\n");
				int a2 = input. nextInt();
			
				if(a2==1)	
				{
					System.out.println("\nȣȣȣ �����ڿ� ���� ���� ���� ������\n\n������ ������ ���� �������� ���Գ�\n");
					Thread.sleep(1500);
					int a3 = (int)(Math.random()*4);
				
				
					if( a3==0) 
					{
						System.out.println("\n������ ���� ����ϱ�.... ���� �����϶�... ū���� �������־�\n");
						User[0][0][3]-=2;
						if (User[0][0][3] < 0) User[0][0][3] = 0;
						Thread.sleep(1500);
					}
				
					if(a3==1)
					{
						System.out.println("\n�̷� ��鼭 ������ ó�����±�... ���.. ����� ������!\n");
						User[0][0][3]-=5;
						if (User[0][0][3] < 0) User[0][0][3] = 0;
						Thread.sleep(1500);
					}
				
					if(a3==2)
					{
						System.out.println("\n��...������ �� �� ���ٱ���.. \n�����ϵ� �����ϵ� �Ͼ�� �ʾ�...\n");
						//��� �״��	
						Thread.sleep(1500);
					}
					if(a3==3)
					{
						System.out.println("\n��! ���� ��������.. Ʋ������ ������ �������� ������̾�\n");
						User[0][0][3]+=2;
						Thread.sleep(1500);	
					}

					if(a3==4)
					{
						System.out.println("\n�̷� ���� ������ ��鼭 ó�����±�!!\n ��� �����̶� �纸�°� ��ڳ�?\n");
						User[0][0][3]+=5;	
						Thread.sleep(1500);
					}
				
				}
			
				if(a2==2)
				{
					System.out.println("\n���� ���͵� �ƴϸ鼭 �� ���� �ǰž�?\n\n�������̳� ���ð� ���� �ٻ� �� �̶��!!\n");
					System.out.println("\n�����̰� �ڸ��� �����ϴ�.\n");
					Thread.sleep(1500);
				}
			
			}
			if(a1==2)
			{	
				System.out.println("\n\n����� �����̸� �����ƴ�.\n");
				Thread.sleep(1500);
			}
		}

		catch(InputMismatchException ex)
		{
			System.out.println("�߸��� �Է��Դϴ�. �����̸� ����Ĩ�ϴ�.");
			Thread.sleep(1500);
			return User;
		}
		
		return User;
	}

	


	public static int[][][] Hole (int[][][] User) throws InterruptedException, IOException 
	{	Scanner input = new Scanner(System.in);
		try
		{
			System.out.printf("��� ���� Ŀ�ٶ� ���ۿ� ���� ���Ƚ��ϴ�. ���ۿ��� �������;� �մϴ�. \n\n");
			System.out.printf("������ �ö󰡱� ���� 8���� �����ּ��� : ");
			int a1 = input.nextInt();
		
			int Depth = rd.nextInt(100);
			double a4 = 0.4;
	
			while(true)
			{
				if (a1 == 8)
				{
					System.out.printf("\n\n\n������ �ö󰡴� ���Դϴ�.\n");
					Thread.sleep(1500);

					int fail = (int)(Math.random()*User[0][6][3]);

					if(fail <= User[0][0][7])
					{
						System.out.printf("\n\n���� ��� �̲��������ϴ�. �����ؼ� �ٽ� �ö󰩽ô�.\n");
						a4 += 0.1;
					}
					else break;
				}

				else
				{
					System.out.printf("8���� �����ּž� �մϴ�. 8���� �����ּ��� \n");
					a1 = input.nextInt();
				}
			}

	
			System.out.printf("\n\n");
			int last = (int)(a4 * User[0][6][5]);
			System.out.printf("������ �� �ö� �Խ��ϴ�. (ü�� -%d)\n",last);
			User[0][0][0] -= last;
			User[0][6][0] -= last;
		
		}
		catch(InputMismatchException ex)
		{
			System.out.println("�߸��� �Է��Դϴ�. �����̿��� ���� �׽��ϴ�.");
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
			System.out.printf("�氡�� ��� ������ �ִ°��� �߰��߽��ϴ�. �ֿ�ðڽ��ϱ�?\n");
			System.out.println("�ݴ´� : 1, �׳� �д� : 2");

			int a1 = input.nextInt();
			if(a1==1)
			{
				int a2 =rd.nextInt(User[0][6][3]) + 1;
				System.out.printf("\n\n��� +%d",a2);
				User[0][0][6] += a2;
				
				if (rd.nextInt(100) > User[0][6][3])
				{	Thread.sleep(1500);
					System.out.println("\n\n??? : �ű� ���, ���� ���� �ϴ� ����?");
					Thread.sleep(2000);
					System.out.println("\n\n������ ��Ÿ�����ϴ�!");
					Thread.sleep(1500);
					System.out.println("\n\n���� : ����� ���� ��������� ��� ü���մϴ�.");
					Thread.sleep(1500);
					System.out.printf("\n\n����� ���� ���� ��� �������� �����.\n(��� -%d)", User[0][0][6]);
					User[0][6][6] = 0;
					User[0][0][6] = 0;
				}

			}

			if(a1==2)
			{
				System.out.println("\n\n���� ���� ���ϴ�...");
			}
		}
		catch(InputMismatchException ex)
		{
			System.out.println("�߸��� �Է��Դϴ�. ���� ���� ���ϴ�.");
			return User;
		}
		return User;
	}


	public static int[][][] Will(int[][][] User) throws InterruptedException, IOException
	{	Scanner input = new Scanner(System.in);
		System.out.print("\n\t��");
		Thread.sleep(500);
		System.out.print("\b\b��");
		Thread.sleep(500);
		System.out.print("\b\b��");
		Thread.sleep(500);
		System.out.print("\b\b��");
		Thread.sleep(500);
		System.out.print("\b\b��");
		Thread.sleep(500);
		System.out.print("\b\b��");
		Thread.sleep(500);
		System.out.print("\b\b��");
		Thread.sleep(500);
		System.out.print("\b\b��");
		Thread.sleep(500);		

		System.out.println("\n\n�� �տ� ���𰡰� ������ �ֽ��ϴ�.");
		System.out.println("\n\n�ǵ帮�ðڽ��ϱ�?  �� : 1, �ƴϿ� : 2");
		String s = input.nextLine();

		if(s.equals("1"))
		{
			System.out.println("\n\n����� ������ ���� á��.");
			User[0][0][0] = User[0][0][5];
		}
		else System.out.println("\n\n����� ���� ���� ����.");

		return User;
	}


	public static int[][][] Strange (int [][][] User) throws InterruptedException, IOException
	{	Scanner input = new Scanner(System.in);
		if(route <= 1)
		{
			System.out.println("\n\n??? : �����, �� �� �����ֽǷ���?");
			System.out.println("\n\n���� ���ڰ� ��ſ��� ������ ���մϴ�. ��� �Ͻðڽ��ϱ�?");
			System.out.println("�����ش� : 1, ���� : 2");
			String select = input.nextLine();

			if (select.equals("1") && route == 0)
			{
				System.out.println("\n\n??? : ���� ��� �׷��� �� 50��常 �ֽ� �� �����Ű���?\n�ش� : 1, ���� : 2");
				String r1select = input.nextLine();

				if(r1select.equals("1") && User[0][0][6] >= 50)
				{
					User[0][0][6] -= 50;
					User[0][0][4] += 3;
					System.out.println("\n\n??? : �����մϴ�. �� ������ ���� �ʰڽ��ϴ�.");
					Thread.sleep(1500);
					System.out.println("\n\n���ڰ� ����� �������ϴ�.");
					System.out.println("(��� -50, ���� +3)\n");
					Thread.sleep(1500);
				}	

				else if(r1select.equals("1") && User[0][0][6] < 50)
				{
					System.out.println("\n\n\n??? : ����? �ŷ������ݾ�?\n\n���ڴ� ����� �������ϴ�.");
					Thread.sleep(1500);
				}

				else
				{
					System.out.println("\n\n??? : �׷���, ���� �ʰڴٸ� ��¿ �� ����...");
					Thread.sleep(1500);
					System.out.println("\n\n���ڰ� ����� ������ ���� ��ϴ�!");
					Thread.sleep(1500);
					System.out.println("\n\n�����Ͻðڽ��ϱ�?\n�� : 1, �ƴϿ� : 2");
					String r11select = input.nextLine();
	
					if(r11select.equals("1"))
					{
						System.out.println("\n\n����� ���ڸ� �����ߴ�!");
						revenge = true;
						Thread.sleep(500);
						int MoneyStolen = rd.nextInt(User[0][0][6]);
						User[0][0][6] -= MoneyStolen;
						System.out.printf("\n\n������ ���� ���� ��Ű�� ������ �����ߴ�! (��� -%d)\n\n", MoneyStolen);
						Thread.sleep(1500);
					}	
	
					else
					{
						System.out.printf("\n\n���ڴ� ����� ���� ���� ��������!(��� -%d)", User[0][0][6]);
						Thread.sleep(1500);
						User[0][0][6] = 0;
					}			
								
				}
			
				route ++;
			}
	
			else if(select.equals("1") && route == 1 && !revenge)
			{
				System.out.println("\n\n??? : ��! ����� ������ �� ������� �� ���̱���!");
				Thread.sleep(1500);
				System.out.println("\n\n���� ���ڰ� ��ſ��� ��ʸ� �ϰ�� �������ϴ�.");
				System.out.println("(��� + 100, ���� + 50)");
				Thread.sleep(1500);
				User[0][0][6] += 100; User[0][0][4] += 5;
				route ++;
			}

			else if(select.equals("1") && route == 1 && revenge)
			{
				System.out.println("\n\n�迡�� ������ ����� ��������...");
				Thread.sleep(1500);
				System.out.println("\n\n���ڰ� ����� Į�� �񷶴�!");
				User[0][0][0] = 0;
				User[0][6][0] = 0;
				Thread.sleep(1500);
			}


			else if(select.equals("2"))
			{
				System.out.println("\n\n����� �׸� �����ϰ� �����ƴ�.\n");
				Thread.sleep(1500);
			}
			else
			{	Thread.sleep(1500);
				System.out.println("\n\n���ڴ� ����� ���� ����� �޾Ƴ���.\n");
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
		System.out.println("\n\n������ ���� �ֽ��ϴ�. �о�ðڽ��ϱ�?\n�� : 1, �ƴϿ� : 2\n");
		String select = input.nextLine();

		if(select.equals("1"))
		{
			if(a<10)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n...������ �Ǹ� �η����϶�...");
				Thread.sleep(2500);
				System.out.println("\n\n�� �� ���� �����κ��� �������� �����.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(���� + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;				
			}

			else if(a<15)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n...���� ������, ������ ������, ���� �ٷ� ��ݺ��̴�!");
				Thread.sleep(2500);
				System.out.println("\n\n���� �𸣰� �ϴÿ��� Ŀ�ٶ� ���� ���ٴ� ����� �Ǿ���.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(���� + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}

			else if(a<24)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n...**��, ��� ��... �� ������... �������� ���̾�, ...");
				Thread.sleep(2500);
				System.out.println("\n\n��� ���� �����������. ����� �� �ڸ����� ������ ������.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(���� - %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]-= Awake;
								
			}

			else if(a<35)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n��...�� �� ��... ������ �기 �� ��... �� �� ���� ������ ���� �� ���� ...");
				Thread.sleep(2500);
				System.out.println("\n\n���������� ��Ҹ���. ����� ������ ������ ������.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(���� + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}

			else if(a<39)
			{	
				Thread.sleep(1500);
				System.out.println("\n\nTo be or not To be, that is the question");
				Thread.sleep(2500);
				System.out.println("\n\n������ ���� ����̴�. ��ſ��� ����ħ�� �ش�.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(���� + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}

			else if(a<47)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n!@#%$#^@#$@#$!#^#%&%#$#$%@)*&^");
				Thread.sleep(2500);
				System.out.println("\n\n���¸� �˾ƺ� �� ���� ���ڵ��̴�. ������ �Ͻ��ϴ� �ɱ�?");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(���� + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}

			else if(a<54)
			{	
				Thread.sleep(1500);
				System.out.println("\n\nOOH, Majestic! Hunter is a hunter even in a dream!");
				Thread.sleep(2500);
				System.out.println("\n\n�� ���� ������ ��ɲۿ� ���� ������ �� ����.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(���� + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}

			else if(a<59)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n...�Ŷ��� �źδ� Ŀ�ǽð��� �ʴ�Ǿ���. �׳� Ŀ�Ǹ� ������ �ҳ�ҳ�� ���...");
				Thread.sleep(2500);
				System.out.println("\n\nå�� �� �κ��� ������ �ִ�. ���� å�� ���� �� �� ����.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(���� + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}

			
			else if(a<68)
			{	
				Thread.sleep(1500);
				System.out.println("\n\n���ֱ�� ����");
				Thread.sleep(2500);
				System.out.println("\n\n���� ���� ��ȣ�� �� ����.");
				Awake = rd.nextInt((int)(User[0][6][3]/User[0][0][7])+1)+5;
				System.out.printf("(���� + %d)\n\n", Awake);
				Thread.sleep(1500);
				User[0][0][4]+= Awake;
								
			}


			else
			{
				System.out.println("\n\n�� �� �����̴�.");
				Thread.sleep(1500);
			}
		}
		else
		{
			System.out.println("\n\n����� ������ �����ƴ�.");
			Thread.sleep(1500);	
		}
		return User;
	}

	public static int[][][] Garbage(int[][][] User) throws InterruptedException
	{	Scanner input = new Scanner(System.in);
		System.out.println("����� ��������̸� �����ߴ�.");
		Thread.sleep(1500);
		System.out.println("\n\n��� �Ͻðڽ��ϱ�?\n1. �����Ѵ�, 2. ����ģ��.");
		String select = input.nextLine();
		while(select.equals("1"))
		{	int trash = rd.nextInt(User[0][6][3]);
			int met = rd.nextInt(100);
			if(trash < 4)
			{
				System.out.println("\n\n�ƹ��� ������ ������ ���Դϴ�.");
			}
			
			else if(trash < 6)
			{
				System.out.println("\n\n�ƹ� ¦���� ���� ���� �����⸦ ã�ҽ��ϴ�.");
			}
			else if(trash < 9 && met<50)
			{	int Stt = rd.nextInt((int)(50/User[0][6][2])+1)+1;
				System.out.printf("\n\n���� ���������� ���� �������ϴ�.\n(ü�� -%d)\n\n",Stt);
				User[0][0][0] -= Stt;
				User[0][6][0] -= Stt;
				Thread.sleep(1500);
			}
			else if(trash < 10&& met<50)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)+1;
				System.out.printf("\n\n������ ������ �� �ذ��� �߰��߽��ϴ�.\n(���� +%d)\n\n",Stt);
				User[0][0][4] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 12&& met<50)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)*2+1;
				System.out.printf("\n\n������ ���� ������ �� ������ �߰��߽��ϴ�.\n(���� +%d)\n\n",Stt);
				User[0][0][4] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 16&& met<50)
			{	int Stt = rd.nextInt((int)(50/User[0][6][2])+1)*2+1;
				System.out.printf("\n\n���� ������ ����� �׸� �����Ͽ����ϴ�.\n(ü�� -%d)\n\n",Stt);
				User[0][0][0] -= Stt;
				User[0][6][0] -= Stt;
				Thread.sleep(1500);
			}
			else if(trash < 17&& met<40)
			{	int Stt = rd.nextInt((User[0][6][3]/User[0][0][7])+1)+1;
				System.out.printf("\n\n������ å���� �ź��� �ֹ��� �����ƽ��ϴ�.\n(��� +%d)\n\n",Stt);
				User[0][0][3] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 20&& met<40)
			{	int Stt = rd.nextInt((User[0][6][3]/User[0][0][7])+1)*2+1;
				System.out.printf("\n\n���� ������ �߰���s���ϴ�. ���� ����� ����� �ְ����ϴ�.\n(��� +%d)\n\n",Stt);
				User[0][0][3] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 22&& met<40)
			{	int Stt = rd.nextInt((int)(User[0][6][3]/2)+1)+1;
				System.out.printf("\n\n�̻��� ������ �߰��߽��ϴ�. ��� ���� ����� ����� �ڵ����ϴ�.\n(��� -%d)\n\n",Stt);
				User[0][0][3] -= Stt;
				if(User[0][0][3] < 0) User[0][0][3] =0;
				Thread.sleep(1500);
			}
			else if(trash < 24&& met<40)
			{	int Stt = rd.nextInt((int)(User[0][6][3]/2)+1)*2+1;
				System.out.printf("\n\n������ ������ ã�ҽ��ϴ�. ����� �ſ� �����������ϴ�.\n(��� -%d)\n\n",Stt);
				User[0][0][3] -= Stt;
				if(User[0][0][3] < 0) User[0][0][3] =0;
				Thread.sleep(1500);
			}
			else if(trash < 25&& met<30)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)+1;//
				System.out.printf("\n\n�Ź̿��� ���Ƚ��ϴ�.\n(���� +%d)\n\n",Stt);
				User[0][0][1] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 27&& met<30)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)*2+1;
				System.out.printf("\n\n�� �� ���� ��û�� �� �ֻ�⿡ ��Ƚ��ϴ�.\n(���� +%d)\n\n",Stt);
				User[0][0][1] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 29&& met<30)
			{	int Stt = rd.nextInt((int)(User[0][6][2]/1.3)+1)+1;
				System.out.printf("\n\n������ �տ� �������ϴ�.\n(��� -%d)\n\n",Stt);
				User[0][0][2] -= Stt;
				if(User[0][0][2] < 0) User[0][0][2] =0;
				Thread.sleep(1500);
			}
			else if(trash < 31&& met<30)
			{	int Stt = rd.nextInt((int)(User[0][6][2]/1.3)+1)*2+1;
				System.out.printf("\n\n�������� ����� �Ӹ��� ���� �ٿ����ϴ�.\n(��� -%d)\n\n",Stt);
				User[0][0][2] -= Stt;
				if(User[0][0][2] < 0) User[0][0][2] =0;
				Thread.sleep(1500);
			}
			else if(trash < 33&& met<20)
			{	int Stt = rd.nextInt((User[0][6][0]/User[0][6][3])+1)*3+1;
				System.out.printf("\n\n�������� ����� ������� �ķ�������ϴ�.\n(ü�� -%d)\n\n",Stt);
				User[0][0][0] -= Stt;
				User[0][6][0] -= Stt;
				Thread.sleep(1500);
			}
			else if(trash < 34&& met<20)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)+1;
				System.out.printf("\n\n�λ� ������� �߰��߽��ϴ�. ���������� ����� �׳� �Ա�� �մϴ�.\n(�ִ�ü�� +%d)\n\n",Stt);
				User[0][0][5] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 37&& met<20)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)*2+1;
				System.out.printf("\n\n�Ͼ� ������ ã�ҽ��ϴ�. ����ģ ���� ������ ������ �ǰ��� �����ϴ�.\n(�ִ�ü�� +%d)\n\n",Stt);
				User[0][0][5] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 39&& met<20)
			{	int Stt = rd.nextInt(User[0][6][5]+1)+1;
				System.out.printf("\n\n������ ������ ��Ź�� ��ſ��� ���ָ� ���Ƚ��ϴ�.\n(�ִ�ü�� -%d)\n\n",Stt);
				User[0][0][5] -= Stt;
				if(User[0][0][5] < 1) User[0][0][5] =1;
				Thread.sleep(1500);
			}
			else if(trash < 42&& met<10)
			{	int Stt = rd.nextInt((User[0][6][6]/User[0][6][3])+1)*2+1;
				System.out.printf("\n\n����� ���ڱ� ��������̸� ������ �ڽſ��� ȸ�ǰ��� �������ϴ�.\n(�ִ�ü�� -%d)\n\n",Stt);
				User[0][0][5] -= Stt;
				if(User[0][0][5] < 1) User[0][0][5] =1;
				Thread.sleep(1500);
			}
			else if(trash < 45&& met<10)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)+1;
				System.out.printf("\n\n����� �����⸦ ������ ����, ��ݾ��� �ϴÿ��� ��ȣ�� �����Խ��ϴ�.\n(��� +%d)\n\n",Stt);
				User[0][0][2] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 50&& met<10)
			{	int Stt = rd.nextInt((User[0][6][3]+User[0][0][7])+1)*2+1;
				System.out.printf("\n\n������ �ʴ� ���� ������ ��ſ��� �����ɴϴ�.\n(��� +%d)\n\n",Stt);
				User[0][0][2] += Stt;
				Thread.sleep(1500);
			}
			else if(trash < 55&& met<10)
			{	int Stt = rd.nextInt((int)(User[0][0][6]/1.1)+1)+1;
				System.out.printf("\n\n�ʹ� ���翡 ������ ������, ����� ��带 ��Ƚ��ϴ�.\n(��� -%d)\n\n",Stt);
				User[0][0][6] -= Stt;
				if(User[0][0][6] < 0) User[0][0][6] =0;
				Thread.sleep(1500);
			}
			else if(trash < 58 && met<5)
			{	
				System.out.printf("\n\n�������� ����� ������ ���� �޾Ƴ����ϴ�.\n(��� -%d)\n\n",User[0][0][6]);
				Thread.sleep(1500);
				User[0][0][6] = 0;
				User[0][6][6] = 0;
			}
			else if(trash < 62 && met<5)
			{	
				System.out.printf("\n\n��ġ�� ������ �۵��߽��ϴ�. ����� ��ȭ���� �¾ҽ��ϴ�.\n\n");
				User[0][0][0] = 0;
				User[0][6][0] = 0;
			}
			else if(trash < 65 && met<5)
			{
				int Stt = rd.nextInt(User[0][0][7] + User[0][6][3])+1;
				System.out.printf("\n\n������ ��带 �ֿ����ϴ�.\n(��� +%d)\n\n",Stt);
				User[0][0][6] += Stt;
				Thread.sleep(1500);
			}

			else
			{
				System.out.println("\n\n�����⸦ ã�ҽ��ϴ�.");
			}

			if(User[0][0][0] <= 0) break;
			System.out.println("\n\n���縦 ����Ͻðڽ��ϱ�?\n1. ��, 2. �ƴϿ�");
			select = input.nextLine();
				
		}
		if(User[0][0][0] > 0) System.out.println("\n\n�����⸦ ����Ĩ�ϴ�.");	
		Thread.sleep(1500);
		return User;
	}








}