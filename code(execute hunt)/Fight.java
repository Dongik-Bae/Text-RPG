import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class Fight
{	
	static int[] Status = {0,0,0,0,0,0,0,0};
	static String MonsterName = "";

	public static void DotLine()
	{
		System.out.print("\n\n\n----------------------------------------------------------\n\n\n");
	}


	Fight(){}

	Fight(int a, int b, int c, int d, int e, int f, int g, int h, String Name)
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

	public static int[][][] MetMonster(int [][][] User) throws InterruptedException, IOException
	{
		Random rd = new Random();
		
		int value = rd.nextInt(44) + 1;

		if (value == 1)
		{
			Fight a1 = new Fight(2, 3, 2, 1,10,0,20,1, "�ܰ��� ���ɽð�");
			System.arraycopy(a1.Battle(User),0,User,0,User.length);			

		}
		if (value == 2)
		{
			Fight a2 = new Fight(3, 5, 3, 1,10,0,20,1, "�ް�");
			System.arraycopy(a2.Battle(User),0,User,0,User.length);			

		}
		if (value == 3)
		{
			Fight a3 = new Fight(5, 7, 2, 1,10,0,20,1, "�б� ����");
			System.arraycopy(a3.Battle(User),0,User,0,User.length);			

		}
		

		if (value == 4)
		{
			Fight a4 = new Fight(5, 7, 2, 1,6,0,10,1, "��û�� ��ѱ�");
			System.arraycopy(a4.Battle(User),0,User,0,User.length);			

		}

		if (value == 5)
		{
			Fight a5 = new Fight(6,7 , 3, 1,8,0,10,1, "���� ���� ����");
			System.arraycopy(a5.Battle(User),0,User,0,User.length);		



		}
		if (value == 6 )
		{
			Fight a6 = new Fight(6, 8, 3, 2,7,0,10,1, "������ ������");
			System.arraycopy(a6.Battle(User),0,User,0,User.length);		


		}
		if (value == 7)
		{
			Fight a7 = new Fight(7, 8, 3, 2,7,0,15,1, "��븮�� �˹ٻ�");
			System.arraycopy(a7.Battle(User),0,User,0,User.length);		


		}
		if (value == 8)
		{
			Fight a8 = new Fight(8, 9, 3, 2,7,0,15,1, "���� ����� �ܺ���");
			System.arraycopy(a8.Battle(User),0,User,0,User.length);		


		}

		if (value == 9)
		{
			Fight a9 = new Fight(9, 10, 3, 2,7,0,10,1, "�Ͼ�� ���� 1���� ����");
			System.arraycopy(a9.Battle(User),0,User,0,User.length);			

		}
		if (value == 10)
		{
			Fight a10 = new Fight(10, 11, 2, 2,8,0,12,1, "1���� ���ٴ� �׳��� ���� 2���ü���");
			System.arraycopy(a10.Battle(User),0,User,0,User.length);			

		}
		if (value == 11)
		{
			Fight a11 = new Fight(11, 12, 3, 2,9,0,13,1, "���ɸ԰� ����� 3���� ����");
			System.arraycopy(a11.Battle(User),0,User,0,User.length);			

		}
		if (value == 12)
		{
			Fight a12 = new Fight(11, 13, 2, 2,9,0,15,1, "���� �� ������ ���� 4���� ����");
			System.arraycopy(a12.Battle(User),0,User,0,User.length);			

		}
		if (value == 13)
		{
			Fight a13 = new Fight(11, 13, 3, 2,10,0,15,1, "� ���� ������� 5���� ����");
			System.arraycopy(a13.Battle(User),0,User,0,User.length);			

		}
		if (value == 14)
		{
			Fight a14 = new Fight(12, 14, 2, 2,10,0,17,1, "�߰��� �� ������ �����ð�");
			System.arraycopy(a14.Battle(User),0,User,0,User.length);			

		}
		if (value == 15)
		{
			Fight a15 = new Fight(12, 15, 2, 3,10,0,20,1, "���ϱ��� �ؾ��ϴ� ����");
			System.arraycopy(a15.Battle(User),0,User,0,User.length);			

		}

		if (value == 16)
		{
			Fight b1 = new Fight(13, 15, 4, 3,13,0,21,2, "�ѹ��� ġ�� ����");
			System.arraycopy(b1.Battle(User),0,User,0,User.length);			

		}
		if (value == 17)
		{
			Fight b2 = new Fight(13, 15, 4, 3,13,0,22,2, "�⸻ ������ �����ϴ� ����Ʈ");
			System.arraycopy(b2.Battle(User),0,User,0,User.length);			

		}
		if (value == 18)
		{
			Fight b3 = new Fight(14, 16, 4, 3,13,0,22,2, "1���� �⼮üũ");
			System.arraycopy(b3.Battle(User),0,User,0,User.length);			

		}
		if (value == 19)
		{
			Fight b4 = new Fight(14, 16, 4, 3,15,0,23,2, "�ָ��� �ϴ� ����");
			System.arraycopy(b4.Battle(User),0,User,0,User.length);			

		}

		if (value == 20)
		{
			Fight b5 = new Fight(15, 16, 4, 3,15,0,23,2, "�Ϲ� ���� �����");
			System.arraycopy(b5.Battle(User),0,User,0,User.length);

		}
		if (value == 21)
		{
			Fight b6 = new Fight(17, 17, 4, 3,15,0,24,2, "���� ���� �����");
			System.arraycopy(b6.Battle(User),0,User,0,User.length);


		}
		if (value == 22)
		{
			Fight b7 = new Fight(18, 18, 4, 3,15,0,24,2, "�л��Ĵ� ���ָӴ�");
			System.arraycopy(b7.Battle(User),0,User,0,User.length);


		}
		if (value == 23)
		{

			Fight b8 = new Fight(18, 19, 4, 3,16,0,24,2, "���� ���ָӴ�");
			System.arraycopy(b8.Battle(User),0,User,0,User.length);

		}
		if (value == 24)
		{
			Fight b9 = new Fight(19, 20, 4, 5,17,0,25,2, "���� °�� ���ô� �а� ����");
			System.arraycopy(b9.Battle(User),0,User,0,User.length);

		}
		if (value == 25)
		{
			Fight b10 = new Fight(19, 21, 4, 5,17,0,25,2, "�����ִ� �а� ����");
			System.arraycopy(b10.Battle(User),0,User,0,User.length);

		}

		if (value == 26)
		{
			Fight c1 = new Fight(27, 22, 5, 2,17,0,30,3, "����ִ� ���Ƹ� ȸ���");
			System.arraycopy(c1.Battle(User),0,User,0,User.length);


		}
		if (value == 27)
		{
			Fight c2 = new Fight(28, 23, 5, 2,17,0,30,3, "�ڱ� �ַ��� �𸣰� ���� �� ���Ի�");
			System.arraycopy(c2.Battle(User),0,User,0,User.length);


		}
		if (value == 28)
		{
			Fight c3 = new Fight(29, 24, 6, 2,18,0,30,3, "���� �� �޶�� �а� �Ĺ�");
			System.arraycopy(c3.Battle(User),0,User,0,User.length);

		}
		if (value == 29)
		{
			Fight c4 = new Fight(31, 25, 6, 2,18,0,32,3, "�������� ���ӽ��� ����");
			System.arraycopy(c4.Battle(User),0,User,0,User.length);

		}
		if (value == 30)
		{
			Fight c5 = new Fight(33, 26, 5, 2,19,0,32,3, "�˱��� ��� ���� ����");
			System.arraycopy(c5.Battle(User),0,User,0,User.length);
		}

		if (value == 31)
		{
			Fight c6 = new Fight(35, 27, 5, 3,19,0,32,3, "�������� �Ȱ��� �б� ģ��");
			System.arraycopy(c6.Battle(User),0,User,0,User.length);

		}

		if (value == 32)
		{
			Fight c7 = new Fight(36, 28, 7, 3,20,0,34,3, "����� �� ����ģ��");
			System.arraycopy(c7.Battle(User),0,User,0,User.length);

		}

		if (value == 33)
		{
			Fight c8 = new Fight(37, 29, 9, 3,20,0,34,3, "����� �� ����ģ��");
			System.arraycopy(c8.Battle(User),0,User,0,User.length);

		}

		if (value == 34)
		{
			Fight c9 = new Fight(38, 30, 11, 4,20,0,34,3, "���� ���ϸ� �ٷ� ��ġ�� �ܱ��� ������");
			System.arraycopy(c9.Battle(User),0,User,0,User.length);

		}

		if (value == 35)
		{
			Fight c10 = new Fight(39, 29, 13, 5,17,0,35,3, "���ʷ� ���� ����� �Ͻô� ���� ������");
			System.arraycopy(c10.Battle(User),0,User,0,User.length);

		}

		if (value == 36)
		{
			Fight c11 = new Fight(40, 28, 15, 5,21,0,35,3, "��㶧�� �ѹ��� �˴� ���������� ");
			System.arraycopy(c11.Battle(User),0,User,0,User.length);

		}

		if (value == 37)
		{
			Fight d1 = new Fight(46, 30, 16, 2,23,0,35,4, "���� �⼮üũ �Ͻô� ���� ������");
			System.arraycopy(d1.Battle(User),0,User,0,User.length);

		}

		if (value == 38)
		{
			Fight d2 = new Fight(47, 30, 17, 2,24,0,38,4, "������ ���� ������");
			System.arraycopy(d2.Battle(User),0,User,0,User.length);

		}

		if (value == 39)
		{
			Fight d3 = new Fight(48, 31, 16, 2,25,0,40,4, "������ ��¡ F����");
			System.arraycopy(d3.Battle(User),0,User,0,User.length);
		}

		if (value == 40)
		{
			Fight d4 = new Fight(50, 32, 18, 2,27,0,45,4, "�޾ƺ� ����� �ȴٴ� D����");
			System.arraycopy(d4.Battle(User),0,User,0,User.length);

		}

		if (value == 41)
		{
			Fight d5 = new Fight(51, 32, 19, 2,28,0,47,4, "�⼮�� ������ ������ ���ƴ� C����");
			System.arraycopy(d5.Battle(User),0,User,0,User.length);
		}

		if (value == 42)
		{
			Fight d6 = new Fight(52, 33, 20, 2,29,0,48,4, "�Ƚɰ� �ƽ����� ���� B����");
			System.arraycopy(d6.Battle(User),0,User,0,User.length);
		}

		if (value == 43)
		{
			Fight e1 = new Fight(70, 40, 25, 2,30,0,50,5, "�������� ����� �밡  A����");
			System.arraycopy(e1.Battle(User),0,User,0,User.length);

		}

		if (value == 44)
		{
			Fight e2 = new Fight(80, 40, 30, 15,35,0,55,5, "A+����");
			System.arraycopy(e2.Battle(User),0,User,0,User.length);
		}

		return User;
	}
	
	public static int[][][] Battle(int [][][] User) throws InterruptedException, IOException
	{	
		Hunt hunt = new Hunt();
		Scanner input = new Scanner(System.in);


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
						System.out.printf("\n����� %s���Լ� �¸��ߴ�!\n", MonsterName);
						System.out.printf("(���� +%d, ��� +%d)\n\n", Status[4], Status[6]);
						User[0][0][4] += Status[4];
						User[0][0][6] += Status[6];
						break;
					}

					System.out.printf("\n%s��(��) ����� �����մϴ�.\n", MonsterName);
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
						break;
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
						System.out.printf("\n%s��(��) ����� �����մϴ�.\n", MonsterName);
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
						break;
					}
				}


			}


		return User;
	}

	public static int DamageCalculation(int Atk, int Def)
	{
		double a = (double)(Atk);
		double d = (double)(Def);
		double RealDamage = 0;

		RealDamage = a*(1- (d/(d+100)));

		return (int)(RealDamage);
	}

	






















}